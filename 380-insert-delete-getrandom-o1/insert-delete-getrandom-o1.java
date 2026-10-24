class RandomizedSet {
    ArrayList<Integer> al;
    HashMap<Integer, Integer> hm;
    Random rand;

    public RandomizedSet() {
        al = new ArrayList<>();
        hm = new HashMap<>();
        rand = new Random();
    }

    public boolean insert(int val) {
        if (hm.containsKey(val)) {
            return false;
        }

        hm.put(val, al.size());
        al.add(val);
        return true;
    }

    public boolean remove(int val) {
        if (!hm.containsKey(val)) {
            return false;
        }

        int index = hm.get(val);
        int lastIndex = al.size() - 1;
        int lastVal = al.get(lastIndex);

        // Move the last value into the removed value's slot
        al.set(index, lastVal);
        hm.put(lastVal, index);

        // Remove the last slot and the target value
        al.remove(lastIndex);
        hm.remove(val);

        return true;
    }

    public int getRandom() {
        int index = rand.nextInt(al.size());
        return al.get(index);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */