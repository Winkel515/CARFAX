package cvr;

import avl.AVL;
import avl.DuplicateVINException;
import avl.Vehicle;
import sequence.Sequence;

import java.util.ArrayList;

public class CVR {
    private long threshold;
    private int keyLength;
    private int size = 0;
    private final AVL avl = new AVL();
    private final Sequence sequence = new Sequence();

    public CVR(){
        threshold = 100000;
        keyLength = 14;
    }

    public CVR(long threshold, int keyLength) throws KeyLengthOutOfBoundsException, ThresholdOutOfBoundsException {
        setKeyLength(keyLength);
        setThreshold(threshold);
    }

    /**
     *
     * @param threshold limit between sequence and AVL
     * @throws ThresholdOutOfBoundsException threshold is too large or too small
     */
    public void setThreshold(long threshold) throws ThresholdOutOfBoundsException {
        if (threshold < 100 || threshold > 900000)
            throw new ThresholdOutOfBoundsException(threshold);
        this.threshold = threshold;
    }

    /**
     *
     * @param keyLength keylength of the vehicles for the data structure
     * @throws KeyLengthOutOfBoundsException the keylength is too short or too long
     */
    public void setKeyLength(int keyLength) throws KeyLengthOutOfBoundsException {
        if (keyLength < 10 || keyLength > 17)
            throw new KeyLengthOutOfBoundsException(keyLength);
        this.keyLength = keyLength;
    }

    /**
     *
     * @param n number of keys
     * @return array of n generated keys
     */
    public ArrayList<String> generate(int n) {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        ArrayList<String> keys = new ArrayList<>(n);

        for (int i = 0; i < n;) {
            String generatedKey = "";
            for (int j = 0; j < keyLength; j++) {
                int randomNum = (int) (Math.random() * (characters.length()));
                generatedKey = generatedKey + characters.substring(randomNum, randomNum + 1);
            }
            if (this.allKeys().contains(generatedKey) || keys.contains(generatedKey))
                continue;
            keys.add(generatedKey);
            i++;
        }
        return keys;
    }

    public boolean usingSequence() {
        return size < threshold;
    }

    public boolean usingAVL() {
        return size >= threshold;
    }

    public ArrayList<String> allKeys() {
        if(usingSequence())
            return sequence.allKeys();
        else
            return avl.allKeys();
    }

    public void add(String key, Vehicle value) throws DuplicateVINException, InvalidKeyException {
        if(key.length() != keyLength || !isAlphaNumerical(key))
            throw new InvalidKeyException(key, keyLength);
        if (allKeys().contains(key))
            throw new DuplicateVINException(key);
        size++;
        if(this.usingAVL()) {
            convertToAVL();
            avl.insert(value);
        } else {
            sequence.addKeys(key, value);
        }
    }

    public void remove(String key) {
        if(usingAVL())
            if(avl.delete(key))
                size--;
        else
            if(sequence.remove(key))
                size--;
    }

    public void convertToAVL() {
        ArrayList<Vehicle> vehicles = sequence.allVehicles();
        for(Vehicle v: vehicles) {
            try {
                avl.insert(v);
            } catch (DuplicateVINException e) {
                e.printStackTrace();
                System.exit(-1);
            }
        }
        sequence.clear();
    }

    public void convertToSequence() {
        ArrayList<Vehicle> vehicles = avl.allVehicles();
        for(Vehicle v: vehicles) {
            try {
                sequence.addKeys(v.getVIN(), v);
            } catch (DuplicateVINException e) {
                e.printStackTrace();
                System.exit(-1);
            }
        }
        avl.clear();
    }

    private boolean isAlphaNumerical(String s) {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        for (int i = 0; i < characters.length(); i++) {
            if(!characters.contains(s.subSequence(i, i+1)))
                return false;
        }
        return true;
    }
}
