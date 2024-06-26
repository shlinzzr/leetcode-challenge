// https://leetcode.com/problems/design-in-memory-file-system

class FileSystem {

    
    TrieNode root;
    
    
    class TrieNode{
        TreeMap<String, TrieNode> map;
        String self="";
        boolean isFile;
        String content;
        
        public TrieNode(String self){
            map= new TreeMap<>();
            this.self = self;
            isFile=false;      
            content=null;
        }
    }
    
    
    
    public FileSystem() {
        root = new TrieNode("//");
        
    }
    
    public List<String> ls(String path) {
         System.out.println("path="+path);
        
        //file , dir in lexicographic order
        
        List<String> res = new ArrayList<>();
        TrieNode node = root;
        
        
        if(!path.equals("/")){
             String[] parr = path.split("/");
            int i=1;
            while(i<parr.length){
                
                System.out.println("parr[i]="+parr[i]);
                
                if(node.map.containsKey(parr[i])){
                    node = node.map.get(parr[i]);
                    i++;
                }else{
                    return new ArrayList<>();
                }
            }
        }
        
        System.out.println(node.map.keySet().size());
        if(node.isFile==true){
            res.add(node.self);
        }else{
            System.out.println(node.map.keySet().size());
            for(String k : node.map.keySet()){
                res.add(k);
            }
        }
        
        return res;
    }
    
    public void mkdir(String path) {
        
        String[] parr = path.split("/");
        TrieNode node = root;
        int i=1;
        
        while(i<parr.length){
            
            if(!node.map.containsKey(parr[i])){
                node.map.put(parr[i], new TrieNode(parr[i]));
            }
            node = node.map.get(parr[i]);
            i++;
        }
        
        
        
    }
    
    public void addContentToFile(String filePath, String content) {
        
        String[] parr = filePath.split("/");
        TrieNode node = root;
        int i=1;
        while(i<parr.length){
            System.out.println("add parr[i]="+parr[i]);
            if(!node.map.containsKey(parr[i])){
                node.map.put(parr[i], new TrieNode(parr[i]));
            }
            node = node.map.get(parr[i]);
            i++;
        }
        node.isFile=true;
        node.content= node.content==null? content: node.content + content;
    }
    
    public String readContentFromFile(String filePath) {
        
        String[] parr = filePath.split("/");
        TrieNode node = root;
        int i=1;
        while(i<parr.length){
            if(node.map.containsKey(parr[i])){
                node = node.map.get(parr[i]);
                i++;
            }else{
                return null;
            }
        }
        
        if(node.isFile==false)
            return null;
        
        return node.content;
        
    }
}

/**
 * Your FileSystem object will be instantiated and called as such:
 * FileSystem obj = new FileSystem();
 * List<String> param_1 = obj.ls(path);
 * obj.mkdir(path);
 * obj.addContentToFile(filePath,content);
 * String param_4 = obj.readContentFromFile(filePath);
 */