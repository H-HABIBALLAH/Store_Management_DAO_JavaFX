package StoreManagement.IHM.Compte;


import java.io.*;
import java.net.Socket;

public class VerifyCompteHandler implements Serializable{
    private Socket socketEnd2 = null;
    private static final int port = 3333;
    private InputStream inputStream = null;
    private OutputStream outputStream = null;
    private FormPaiementCardWindow formPaiementCardWindow;
    private String opInfo;

    private void getReponse(String opInfo){
        BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
        PrintWriter pw = new PrintWriter(outputStream);
        String response = "";
        pw.write(opInfo);
        pw.flush();
        pw.close();
        try {
            this.socketEnd2 = new Socket("127.0.0.1",port);
            inputStream = socketEnd2.getInputStream();
            br = new BufferedReader(new InputStreamReader(inputStream));
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            response = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String s[] = response.split("/");
        if(s[0].equals("1")){
            formPaiementCardWindow.compteExist = true;
            if(s[1].equals("1"))
                formPaiementCardWindow.enoughSolde = true;
            else
                formPaiementCardWindow.enoughSolde = false;
        }
        else
            formPaiementCardWindow.compteExist = false;
    }

    public VerifyCompteHandler(String opInfo, FormPaiementCardWindow formPaiementCardWindow){
        this.opInfo = opInfo;
        try {
            this.socketEnd2 = new Socket("127.0.0.1",port);
            inputStream = socketEnd2.getInputStream();
            outputStream = socketEnd2.getOutputStream();
            this.formPaiementCardWindow = formPaiementCardWindow;
            getReponse(opInfo);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}