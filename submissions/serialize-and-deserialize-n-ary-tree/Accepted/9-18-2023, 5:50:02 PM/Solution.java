// https://leetcode.com/problems/serialize-and-deserialize-n-ary-tree

// /*
// // Definition for a Node.
// class Node {
//     public int val;
//     public List<Node> children;

//     public Node() {}

//     public Node(int _val) {
//         val = _val;
//     }

//     public Node(int _val, List<Node> _children) {
//         val = _val;
//         children = _children;
//     }
// };
// */

// class Codec {
//     // Encodes a tree to a single string.
//     public String serialize(Node root) {
//         StringBuilder sb = new StringBuilder();
        
//         shelper(root, sb);
        
//         return sb.toString();
//     }
    
//     private void shelper(Node node, StringBuilder sb){
        
//         sb.append("[");

//         for(Node child : node.children){
//             sb.append(helper(child, sb));
//             sb.append(", ");
//         }
//         sb.append("]");        
//     }
    
	
//     // Decodes your encoded data to tree.
//     public Node deserialize(String data) {
//         StringBuilder sb = new StringBuilder(data);

//         Node res = dhelper(sb);

//     }

//     private Node dhelper(StringBuilder sb){
//         sb.substring(1, sb.length()-1);

//         List<String> list = new ArrayList<>();

//         int left=0;

//         int st = 0;
//         for(int ed=0; ed<sb.length();ed++){
            
//             char ch = sb.charAt(ed);

//             if(ch=='[')
//                 left++;
//             else if(ch==']')
//                 left--;

//             if(left==0 && ch==','){
//                 list.add(sb.toString().substring(st, ed));
//                 st = ed+1;
//             }
//         }


//         for(String s : list){
            
//         }

//     }



// }

// // Your Codec object will be instantiated and called as such:
// // Codec codec = new Codec();
// // codec.deserialize(codec.serialize(root));



class Codec {

    // Encodes a tree to a single string.
    public String serialize(Node root) {
        List<String> list=new LinkedList<>();
        serializeHelper(root,list);
        return String.join(",",list);
    }
    
    private void serializeHelper(Node root, List<String> list){
        if(root==null){
            return;
        }else{
            list.add(String.valueOf(root.val));
            list.add(String.valueOf(root.children.size()));
            for(Node child:root.children){
                serializeHelper(child,list);
            }
        }
    }

    // Decodes your encoded data to tree.
    public Node deserialize(String data) {
        if(data.isEmpty())
            return null;
        
        String[] ss=data.split(",");
        Queue<String> q=new LinkedList<>(Arrays.asList(ss));
        return deserializeHelper(q);
    }
    
    private Node deserializeHelper(Queue<String> q){
        Node root=new Node();
        root.val=Integer.parseInt(q.poll());
        int size=Integer.parseInt(q.poll());
        root.children=new ArrayList<Node>(size);
        for(int i=0;i<size;i++){
            root.children.add(deserializeHelper(q));
        }
        return root;
    }
}