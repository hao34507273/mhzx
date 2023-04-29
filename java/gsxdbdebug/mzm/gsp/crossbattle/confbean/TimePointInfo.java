/*    */ package mzm.gsp.crossbattle.confbean;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import org.dom4j.Element;
/*    */ 
/*    */ public class TimePointInfo implements Marshal
/*    */ {
/*    */   public int timePoint;
/*    */   public int backupTimePoint;
/*    */   
/*    */   public void loadFromXml(Element rootElement)
/*    */   {
/* 14 */     this.timePoint = Integer.valueOf(rootElement.attributeValue("timePoint")).intValue();
/* 15 */     this.backupTimePoint = Integer.valueOf(rootElement.attributeValue("backupTimePoint")).intValue();
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_)
/*    */   {
/* 20 */     _os_.marshal(this.timePoint);
/* 21 */     _os_.marshal(this.backupTimePoint);
/* 22 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*    */   {
/* 27 */     this.timePoint = _os_.unmarshal_int();
/* 28 */     this.backupTimePoint = _os_.unmarshal_int();
/* 29 */     return _os_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossbattle\confbean\TimePointInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */