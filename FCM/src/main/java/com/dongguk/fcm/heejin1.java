package com.dongguk.fcm;

public class heejin1 {

   public static int[] cost_home = new int[5] ; 
   public static int[] importance = new int[5] ; 
   public static int lowCost = 10000; 
   public static int[] answer = new int[6]; 
   public static int[][] cost = { {0,4,3,4,5,7},{4,0,5,4,5,8},{3,5,0,3,2,5},{4,4,3,0,2,5},{5,5,2,2,0,3},{7,8,5,5,3,0} };
   public static int[][] cost2 = new int[6][6]; 
   public static boolean[] visited = new boolean[6];
   public static int[] stack = new int[8]; 
   public static int size = 0; 
   public static int start;
   public static int num = 0;
   public static int[] input = new int[6];
   public static void receive(int a, int b, int c, int d, int e)
   {
      cost_home[0] = a;
      cost_home[1] = b;
      cost_home[2] = c;
      cost_home[3] = d;
      cost_home[4] = e;
      //sum_of_date = f ; average of trash 
   }
   public static void cal_importance()
   {
      for(int i =0; i<5; i++)
      {
         importance[i] = cost_home[i]*1;   //w1 w2 = ?
      }
   }
   public static void on_off()
   {
      input[0] = 0;
      num++;
      for(int i = 0; i<5; i++)
      {
         if(importance[i]>50)
         {
            input[num] = i+1;
            num++;
         }
      }
   }
   /*public static int get()
   {
      return cost_home;
   }*/
   public static void reset()
   {
      for(int i=0; i<8;i++)
         stack[i]=0;
   }
   public static void input_num() //�湮�� �������� ����,��ġ Ȯ�� �۾�? 
   {
      //�湮�� ���� home(�ʼ� = 0), 1,3,4 �� ����� ���� 
      //int[] input = new int[6]; 
      //int num = 0; 
      /*input[0] = 0;
      num++;
      input[1] = 1;
      num++;
      input[2] = 4;
      num++;
      input[3] = 5;
      num++;
      */
      for(int i =0; i<num; i++)
      {
         for(int j=0; j<num;j++)
         {
            cost2[i][j] = cost[input[i]][input[j]]; 
         }
      }
   }
   public static void reset2()
   {
      for(int i=0; i<num; i++)
         visited[i] = false; 
   }
   //6�� num���� ���� 
   public static void tsp(int node, int costSum, int count)
   {
      visited[node] = true;
      stack[size++] = node; 
      if(count == num)
      {
         tsp(start, costSum + cost2[node][start], count+1);
         --size;
         visited[node] = false;
         return; 
      }
      if(count == num+1)
      {
         if(costSum < lowCost)
         {
            lowCost = costSum;
            System.arraycopy(stack,0,answer,0,6);  //�������� sizeof(stack) ���� �� �ϴ� 6���� ����. 8�� �ȵ� ��? 
            
         }
         --size;
         return;
      }
      for(int i = 0; i<num; i++)
      {
         if(!visited[i] && cost2[node][i] != 0)
         {
            if(costSum + cost2[node][i] < lowCost)
            {
               tsp(i, costSum + cost2[node][i], count+1);
            }
         }
      }
      visited[node] = false;
      --size; 
   }   
   public static int[] heejin()
   {
      int[] heejin = new int[num];
      
      for(int i=0; i<num; ++i)
      {
         //System.out.println(input[answer[i]]); 
         heejin[i] = input[answer[i]]; 
         
      }
      
         /*if(input[answer[]] == 5)
            return 5; 
         else if (input[answer[i]] == 1)
            return 1;
         else if (input[answer[i]] == 2)
            return 2;
         else if (input[answer[i]] == 3)
            return 3;
         else if (input[answer[i]] == 4)
            return 4;
         */
      
      
      return heejin;
   }
   /*public static void heejin()
   {
      for(int i=0; i<num; ++i)
      {
         System.out.println(input[answer[i]]); 
          
         
      }
   }*/
   //heejin0()�� �׻� 0�̴ϱ� ����? 
   public static int heejin1()
   {
      return input[answer[1]];
   }
   public static int heejin2()
   {
      return input[answer[2]];
   }
   public static int heejin3()
   {
      return input[answer[3]];
   }
   public static int heejin4()
   {
      return input[answer[4]];
   }
   public static int heejin5()
   {
      return input[answer[5]];
   }
   
   public static void action()
   {
      for(int i=0; i<num; i++)
      {
         start = i; 
   
         tsp(i,0,1); 
      }
   }
   public static void main(String[] args)
   {
      heejin1 jhj = new heejin1();
      
      jhj.receive(55,25,90,80,40);
      jhj.cal_importance();
      jhj.on_off();
      jhj.reset();
      jhj.input_num();
      /*for(int i=0; i<num; i++)
         jhj.visited[i] = false; 
      */
      jhj.reset2();
      /*for(int i=0; i<num; i++)
      {
         jhj.start = i; 
   
         jhj.tsp(i,0,1); 
      }*/
      jhj.action();
      
      System.out.println(lowCost); 
      
      /*for(int i =0; i<num; ++i)
      {
         System.out.println(input[answer[i]]);
      }*/
      //jhj.heejin(); 
      /*int array[]; 
      array = jhj.heejin(); 
      for(int i=0;i <num; i++)
         System.out.println(array[i]); 
      */
      //jhj.heejin();
      /*int a = heejin5();
      System.out.println("heejin:");
      System.out.println(a); */
      System.out.println("0"); //�������� �翬�� home����!!
      
      /*jhj.input_num();
      
      for(int i=0; i<4; i++)
      {
         for(int j=0; j<4; j++)
            System.out.println(cost2[i][j]);
         System.out.println("\n");
      }*/ //cost2 ��� �غ��� �� 
   }
         
}
   