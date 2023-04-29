/*    */ package mzm.gsp.ballbattle.confbean;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import org.dom4j.Element;
/*    */ 
/*    */ public class SBallBattleCircleBean implements Marshal
/*    */ {
/*    */   public int circleRadius;
/*    */   public int circleReduceSeconds;
/*    */   public int geneItemNumber;
/*    */   
/*    */   public void loadFromXml(Element rootElement)
/*    */   {
/* 15 */     this.circleRadius = Integer.valueOf(rootElement.attributeValue("circleRadius")).intValue();
/* 16 */     this.circleReduceSeconds = Integer.valueOf(rootElement.attributeValue("circleReduceSeconds")).intValue();
/* 17 */     this.geneItemNumber = Integer.valueOf(rootElement.attributeValue("geneItemNumber")).intValue();
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_)
/*    */   {
/* 22 */     _os_.marshal(this.circleRadius);
/* 23 */     _os_.marshal(this.circleReduceSeconds);
/* 24 */     _os_.marshal(this.geneItemNumber);
/* 25 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*    */   {
/* 30 */     this.circleRadius = _os_.unmarshal_int();
/* 31 */     this.circleReduceSeconds = _os_.unmarshal_int();
/* 32 */     this.geneItemNumber = _os_.unmarshal_int();
/* 33 */     return _os_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\ballbattle\confbean\SBallBattleCircleBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */