/*    */ package mzm.gsp.msdkprofile.main.qq;
/*    */ 
/*    */ import java.util.LinkedList;
/*    */ import java.util.List;
/*    */ import jsonio.JsonStream;
/*    */ import org.json.JSONArray;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ReportScoreParams
/*    */ {
/* 12 */   private List<ReportParam> params = new LinkedList();
/*    */   
/*    */   public void addParam(ReportParam param)
/*    */   {
/* 16 */     this.params.add(param);
/*    */   }
/*    */   
/*    */ 
/*    */   public String toString()
/*    */   {
/* 22 */     JSONArray jsonArr = new JSONArray();
/* 23 */     for (ReportParam param : this.params)
/*    */     {
/* 25 */       JsonStream js = new JsonStream();
/* 26 */       param.marshal(js);
/* 27 */       jsonArr.put(js.getJSONObject());
/*    */     }
/* 29 */     return jsonArr.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\msdkprofile\main\qq\ReportScoreParams.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */