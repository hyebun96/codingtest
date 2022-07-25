package CodingTest;

public class Array {
    public static void main(String[] args) {
        System.out.println("-- 위 1차원 배열에서, 문자 M 을 가지고 있는 아이템의 수를 출력해보기 --");

        String dataset[] = {
                "Braund, Mr. Owen Harris",
                "Cumings, Mrs. John Bradley (Florence Briggs Thayer)",
                "Heikkinen, Miss. Laina",
                "Futrelle, Mrs. Jacques Heath (Lily May Peel)",
                "Allen, Mr. William Henry",
                "Moran, Mr. James",
                "McCarthy, Mr. Timothy J",
                "Palsson, Master. Gosta Leonard",
                "Johnson, Mrs. Oscar W (Elisabeth Vilhelmina Berg)",
                "Nasser, Mrs. Nicholas (Adele Achem)",
                "Sandstrom, Miss. Marguerite Rut",
                "Bonnell, Miss. Elizabeth",
                "Saundercock, Mr. William Henry",
                "Andersson, Mr. Anders Johan",
                "Vestrom, Miss. Hulda Amanda Adolfina",
                "Hewlett, Mrs. (Mary D Kingcome) ",
                "Rice, Master. Eugene",
                "Williams, Mr. Charles Eugene",
                "Vander Planke, Mrs. Julius (Emelia Maria Vandemoortele)",
                "Masselmani, Mrs. Fatima",
                "Fynney, Mr. Joseph J",
                "Beesley, Mr. Lawrence",
                "McGowan, Miss. Anna",
                "Sloper, Mr. William Thompson",
                "Palsson, Miss. Torborg Danira",
                "Asplund, Mrs. Carl Oscar (Selma Augusta Emilia Johansson)",
                "Emir, Mr. Farred Chehab",
                "Fortune, Mr. Charles Alexander",
                "Dwyer, Miss. Ellen",
                "Todoroff, Mr. Lalio"
        };

        Integer count = 0;  // 문자 M 을 가지고 있는 아이템의 수
        for(int i=0; i<dataset.length; i++){    // 배열 dataset의 길이 만큼 i 증가
            if(dataset[i].indexOf("M") >= 0){   // indexOf() : String의 문자열에서 인자와 일치하는 문자의 index를 찾아줌,
                                                // 0보다 크거나 같다고 한 이유 : 문자 M이 문자열의 시작에 있을 수 있음으로
                count++;                        // 문자 M 을 갖고 있다면 count 증가
            }
        }
        System.out.println(count);
    }
}

