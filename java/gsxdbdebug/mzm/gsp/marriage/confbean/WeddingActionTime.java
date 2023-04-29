/*    */ package mzm.gsp.marriage.confbean;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import org.dom4j.Element;
/*    */ 
/*    */ public class WeddingActionTime implements Marshal
/*    */ {
/*    */   public int unitStartTime;
/*    */   public int unitEndTime;
/*    */   
/*    */   public void loadFromXml(Element rootElement)
/*    */   {
/* 14 */     this.unitStartTime = Integer.valueOf(rootElement.attributeValue("unitStartTime")).intValue();
/* 15 */     this.unitEndTime = Integer.valueOf(rootElement.attributeValue("unitEndTime")).intValue();
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_)
/*    */   {
/* 20 */     _os_.marshal(this.unitStartTime);
/* 21 */     _os_.marshal(this.unitEndTime);
/* 22 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*    */   {
/* 27 */     this.unitStartTime = _os_.unmarshal_int();
/* 28 */     this.unitEndTime = _os_.unmarshal_int();
/* 29 */     return _os_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\marriage\confbean\WeddingActionTime.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */