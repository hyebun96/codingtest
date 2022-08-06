package CodingTest;

public class MyHashTable_LinearProbing {

    public Slot[] hashtable;

    public MyHashTable_LinearProbing(Integer size){
        hashtable = new Slot[size];
    }

    class Slot{
        private String key;
        private String value;
          public Slot(String key, String vlaue){
              this.key = key;
              this.value = vlaue;
          }
    }

    public boolean saveData(String key, String value){
        int address = hash_func(key);

        if(this.hashtable[address] != null){
           if(this.hashtable[address].key.equals(key)){
               this.hashtable[address].value = value;
               return true;
           } else {
               int currentAddress = address + 1;
               while(this.hashtable[currentAddress] != null){
                   if(this.hashtable[currentAddress].key.equals(key)){
                       this.hashtable[address].value = value;
                   } else {
                       currentAddress++;
                       if(currentAddress >= this.hashtable.length){
                           return false;
                       }
                   }
               }
               this.hashtable[currentAddress] = new Slot(key, value);
               return true;
           }
        } else {
            this.hashtable[address] = new Slot(key, value);
        }
        return true;
    }

    public String getData(String key){
        int address = hash_func(key);

        if(this.hashtable[address] != null){
            if(this.hashtable[address].key.equals(key)){
                return this.hashtable[address].value;
            } else {
                int currentAddress = address + 1;
                while(this.hashtable[currentAddress] != null){
                    if(this.hashtable[currentAddress].key.equals(key)){
                        return this.hashtable[address].value;
                    } else {
                        currentAddress++;
                        if(currentAddress >= this.hashtable.length){
                            return null;
                        }
                    }
                }
                return null;
            }
        } else {
            return null;
        }
    }

    public int hash_func(String name){
        int key = 0;
        for(int i=0; i<name.length(); i++){
            key += name.charAt(i);
        }

        return (int) key % hashtable.length;
    }

    public static void main(String[] args) {
        MyHashTable_LinearProbing mht = new MyHashTable_LinearProbing(20);

        mht.saveData("DaveLee", "01022223333");
        mht.saveData("fun-coding", "01033334444");
        mht.saveData("David", "01044445555");
        mht.saveData("Dave", "01055556666");
        System.out.println(mht.getData("fun-coding"));
    }
}
