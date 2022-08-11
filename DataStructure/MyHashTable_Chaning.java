package DataStructure;

public class MyHashTable_Chaning {
    public Slot[] hashTable;

    public MyHashTable_Chaning(Integer size){
        this.hashTable = new Slot[size];
    }

    public class Slot{
        String key;
        String value;
        Slot next;
        Slot (String key, String value){
            this.key = key;
            this.value = value;
            this.next = null;
        }
    }

    public boolean saveData(String key, String value){
        int address = hashFunc(key);
        if(this.hashTable[address] != null){
            Slot findSlot = this.hashTable[address];
            Slot prevSlot = this.hashTable[address];

            while(findSlot != null){
               if(findSlot.equals(key)){
                   findSlot.value = value;
                   return true;
               } else {
                   prevSlot = findSlot;
                   findSlot = findSlot.next;
               }
            }
            prevSlot.next = new Slot(key, value);
        } else {
            this.hashTable[address] = new Slot(key, value);
        }
        return true;
    }

    public String getData(String key){
        int address = this.hashFunc(key);
        if(this.hashTable[address] != null){
            Slot findSlot = this.hashTable[address];
            while(findSlot != null){
                if(findSlot.key.equals(key)){
                    return findSlot.value;
                } else {
                    findSlot = findSlot.next;
                }
            }
            return null;
        } else {
            return null;
        }
    }

    public int hashFunc(String key){
        return (int)key.charAt(0) %  hashTable.length;
    }

    public static void main(String[] args) {
        MyHashTable_Chaning mht = new MyHashTable_Chaning(20);

        mht.saveData("DaveLee", "01022223333");
        mht.saveData("fun-coding", "01033334444");
        mht.saveData("David", "01044445555");
        mht.saveData("Dave", "01055556666");
        System.out.println(mht.getData("DaveLee"));
    }
}
