(ns exercism.rna-transcription)

(defn dna-to-rna-strand
  [dna-nucleotide]
  (let [complement-table {"G"  "C"
                          "C"  "G"
                          "T"  "A"
                          "A"  "U"}
        rna-nucleotide (complement-table dna-nucleotide)]
    (if (nil? rna-nucleotide)
      (throw (AssertionError. "Invalid DNA Nucleotide"))
      rna-nucleotide)))

(defn to-rna
  [dna]
  (->> (clojure.string/split dna #"")
       (map dna-to-rna-strand)
       (reduce str)))




