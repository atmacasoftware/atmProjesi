import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        String userName, password;
        Scanner input = new Scanner(System.in);
        int right = 3;
        int balance = 1500;
        int select;
        int durum, durum2;
        int price;
        while (right > 0) {
            System.out.print("Kullanıcı Adınız :");
            userName = input.nextLine();
            System.out.print("Parolanız : ");
            password = input.nextLine();

            durum = (userName.equals("patika") && password.equals("dev123")) ? 1 : 2;

            switch (durum){
                case 1:
                    do {
                        System.out.println("1-Para yatırma\n" +
                                "2-Para Çekme\n" +
                                "3-Bakiye Sorgula\n" +
                                "4-Çıkış Yap");
                        System.out.print("Lütfen yapmak istediğiniz işlemi seçiniz : ");
                        select = input.nextInt();
                        switch (select){
                            case 1:
                                System.out.print("Para miktarı : ");
                                price = input.nextInt();
                                balance += price;
                                break;
                            case 2:
                                System.out.print("Para miktarı : ");
                                price = input.nextInt();
                                durum2 = price > balance ? 1 : 2;
                                switch (durum2){
                                    case 1:
                                        System.out.println("Bakiye yetersiz.");
                                        break;
                                    case 2:
                                        balance -= price;
                                        break;
                                }
                                break;
                            case 3:
                                System.out.println("Bakiyeniz : " + balance);
                                break;
                            case 4:
                                right = 0;
                                break;
                        }

                    } while (select != 4);
                    System.out.println("Tekrar görüşmek üzere.");
                    break;
                case 2:
                    right--;
                    System.out.println("Hatalı kullanıcı adı veya şifre. Tekrar deneyiniz.");
                    switch (right){
                        case 0:
                            System.out.println("Hesabınız bloke olmuştur lütfen banka ile iletişime geçiniz.");
                            break;
                        default:
                            System.out.println("Kalan Hakkınız : " + right);
                            break;

                    }
                default:
                    System.out.println("Çıkış yapıldı.");
            }
        }
    }
}