class WordDictionary {

        HashMap<Integer, ArrayList<String>> words;
        public WordDictionary() {
            words = new HashMap<>();
        }
        public void addWord(String word) {
            if (!words.containsKey(word.length())) {
                ArrayList<String> t = new ArrayList<>();
                t.add(word);
                words.put(word.length(), t);
            } else {
                words.get(word.length()).add(word);
            }
        }
        public boolean search(String word) {
            if (words.isEmpty())
                return false;
            if (words.containsKey(word.length())) {
                for (String str : words.get(word.length())) {
                    if (isEqual(str, word))
                        return true;
                }
            }
            return false;
        }
        public boolean isEqual(String a, String b) {
            for (int i = 0; i < a.length(); i++) {
                if (b.charAt(i) == '.')
                    continue;
                if (a.charAt(i) != b.charAt(i))
                    return false;
            }
            return true;
        }
    }

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */