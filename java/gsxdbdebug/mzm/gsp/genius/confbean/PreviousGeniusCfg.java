/*    */ package mzm.gsp.genius.confbean;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import org.dom4j.Element;
/*    */ 
/*    */ public class PreviousGeniusCfg implements Marshal
/*    */ {
/*    */   public int previousGeniusCfgid;
/*    */   public int previousGeniusAddPoint;
/*    */   
/*    */   public void loadFromXml(Element rootElement)
/*    */   {
/* 14 */     this.previousGeniusCfgid = Integer.valueOf(rootElement.attributeValue("previousGeniusCfgid")).intValue();
/* 15 */     this.previousGeniusAddPoint = Integer.valueOf(rootElement.attributeValue("previousGeniusAddPoint")).intValue();
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_)
/*    */   {
/* 20 */     _os_.marshal(this.previousGeniusCfgid);
/* 21 */     _os_.marshal(this.previousGeniusAddPoint);
/* 22 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*    */   {
/* 27 */     this.previousGeniusCfgid = _os_.unmarshal_int();
/* 28 */     this.previousGeniusAddPoint = _os_.unmarshal_int();
/* 29 */     return _os_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\genius\confbean\PreviousGeniusCfg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */