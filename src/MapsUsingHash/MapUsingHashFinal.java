package MapsUsingHash;

import java.util.ArrayList;
import java.util.LinkedList;

public class MapUsingHashFinal<K,  V> {

    private ArrayList<LinkedList<Entity>> list;
    int size = 0;
    double loadFactor = 0.5;

    public MapUsingHashFinal(){
        list = new ArrayList<>();
        for(int i=0; i<10; i++){
            list.add(new LinkedList<>());
        }
    }

    public void put(K key, V value){
        int hash = Math.abs(key.hashCode() % list.size());

        LinkedList<Entity> entities = list.get(hash);

        for(Entity entity:entities){
            if(entity.key.equals(key)){
                entity.value = value;
                return;
            }
        }

        if((double)(size) / list.size() > loadFactor){
            rehash();
        }

        entities.add(new Entity(key, value));
        size++;
    }

    private void rehash() {
        System.out.println("We are now rehasing...!!");
        ArrayList<LinkedList<Entity>> old = list;
        list = new ArrayList<>();

        size = 0;
        for(int i=0; i<old.size()*2; i++){
            list.add(new LinkedList<>());
        }

        for(LinkedList<Entity> entries: old){
            for(Entity entity: entries){
                put(entity.key, entity.value);
            }
        }
    }

    public V get(K key){
        int hash = Math.abs(key.hashCode() % list.size());

        LinkedList<Entity> entities = list.get(hash);

        for(Entity entity:entities){
            if(entity.key.equals(key)){
                return entity.value;
            }
        }

        return null;
    }

    public void remove(K key){
        int hash = Math.abs(key.hashCode() % list.size());

        LinkedList<Entity> entities = list.get(hash);

        Entity target = null;
        for(Entity entity:entities){
            if(entity.key.equals(key)){
                target = entity;
                break;
            }
        }

        if (target != null) {
            entities.remove(target);
            size--;
        }
    }

    public boolean containsKey(K key){
        return get(key) != null;
    }

    @Override
    public String toString(){
        StringBuilder builder = new StringBuilder();
        builder.append("{");
        for(LinkedList<Entity> entities: list){
            for(Entity entity: entities){
                builder.append(entity.key);
                builder.append(":");
                builder.append(entity.value);
                builder.append(", ");
            }
        }
        builder.append(("}"));

        return builder.toString();
    }


    private  class Entity{
        K key;
        V value;
        public Entity(K key, V value){
            this.key = key;
            this.value = value;
        }
    }
}
