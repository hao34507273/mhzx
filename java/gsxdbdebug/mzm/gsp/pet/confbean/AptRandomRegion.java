/*    */ package mzm.gsp.pet.confbean;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import org.dom4j.Element;
/*    */ 
/*    */ public class AptRandomRegion implements Marshal
/*    */ {
/*    */   public int AptLowLimit;
/*    */   public int AptHighLimit;
/*    */   public int AptProb;
/*    */   
/*    */   public void loadFromXml(Element rootElement)
/*    */   {
/* 15 */     this.AptLowLimit = Integer.valueOf(rootElement.attributeValue("AptLowLimit")).intValue();
/* 16 */     this.AptHighLimit = Integer.valueOf(rootElement.attributeValue("AptHighLimit")).intValue();
/* 17 */     this.AptProb = Integer.valueOf(rootElement.attributeValue("AptProb")).intValue();
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_)
/*    */   {
/* 22 */     _os_.marshal(this.AptLowLimit);
/* 23 */     _os_.marshal(this.AptHighLimit);
/* 24 */     _os_.marshal(this.AptProb);
/* 25 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*    */   {
/* 30 */     this.AptLowLimit = _os_.unmarshal_int();
/* 31 */     this.AptHighLimit = _os_.unmarshal_int();
/* 32 */     this.AptProb = _os_.unmarshal_int();
/* 33 */     return _os_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\pet\confbean\AptRandomRegion.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */