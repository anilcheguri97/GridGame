import java.util.Collections;
import java.util.*;

public class NQueenProblem {
    public static void main(String[] args) {
        List<List<String>> result = new ArrayList<>();
        int n = 4;
        char[][] chess = new char[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                chess[i][j] = '.';
        
        dfs(0,chess,result);
        System.out.println("result is "+result);
    }

    private static void dfs(int col, char[][] chess, List<List<String>> result) {
  if(col == chess.length)
  {
      result.add(constructChess(chess));
      return;
  }
        for(int row=0;row<chess.length;row++)
        {
            if(validate(row,col,chess))
            {
                chess[row][col]='Q';
                dfs(col+1,chess,result);
                chess[row][col]='.';
            }
        }

    }

    private static List<String> constructChess(char[][] chess) {
      List<String> list =new ArrayList<>();
      for(int i=0;i< chess.length;i++)
      {
          String s= new String(chess[i]);
          list.add(s);
      }
      return list;
    }

    private static boolean validate(int row, int col, char[][] chess) {
        int dummyrow=row;
        int dummycol=col;
        while(row>=0 && col >= 0)
        {
            if(chess[row][col]=='Q')
                return false;
            row--;
            col--;
        }
        row=dummyrow;
        col=dummycol;
        while(col >= 0)
        {
            if(chess[row][col]=='Q')
                return false;
            col--;
        }
        row=dummyrow;
        col=dummycol;
        while(row>=0 )
        {
            if(chess[row][col]=='Q')
                return false;
            row--;
        }
        row=dummyrow;
        col=dummycol;
        while(col>=0 && row< chess.length)
        {
            if (chess[row][col] == 'Q')
            {
                return false;
            }
            row++;
            col--;
        }
        return true;
    }
}

