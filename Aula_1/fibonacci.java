class fibonacci {
    public static void main(String[] args) {
        
        int primeiro_termo = 1;
        int segundo_termo = 1;
        
        for (int i = 0; i < 30; i++) {
            if (i < 2) {            //Os dois primeiros elementos de fibonacci são 1                
                System.out.println("1");
                continue;
            }
            int soma = primeiro_termo + segundo_termo; 
            System.out.println(soma);
            primeiro_termo = segundo_termo;
            segundo_termo = soma;
        }
        
    }
}