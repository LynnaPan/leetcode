class MyHashMap {

private:
    static const int mod = 13331;
    typedef std::pair<int, int> kv;
    typedef std::list<kv> Chain;
    std::array<Chain, mod> _table;
    
    unsigned int hash(int key){
        return (unsigned int)key % mod;
    }
    
    bool find(int key, Chain::iterator &it){
        Chain &c =  _table[hash(key)];
        for(it = c.begin(); it!= c.end(); it++){
            if(it->first == key)
                return true;
        }
        return false;
    }
    
public:
    /** Initialize your data structure here. */
    MyHashMap() {
    }
    
    /** value will always be non-negative. */
    void put(int key, int value) {
        Chain::iterator it;
        if(find(key, it))
            it->second = value;
        else
            _table[hash(key)].push_back({key, value});
            
    }
    
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    int get(int key) {
        Chain::iterator it;
        if(find(key, it))
            return it->second;
        else
            return -1;
    }
    
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    void remove(int key) {
        Chain &c =  _table[hash(key)];
        for(kv k:c){
            if(k.first == key){
                c.remove(k);
                return;
            }
            
        }
    }
    
};

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap* obj = new MyHashMap();
 * obj->put(key,value);
 * int param_2 = obj->get(key);
 * obj->remove(key);
 */
