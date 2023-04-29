/*    */ package mzm.gsp.petarena.confbean;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import org.dom4j.Element;
/*    */ 
/*    */ public class SectionInfo implements Marshal
/*    */ {
/*    */   public int minSectionOpponent;
/*    */   public int maxSectionOpponent;
/*    */   
/*    */   public void loadFromXml(Element rootElement)
/*    */   {
/* 14 */     this.minSectionOpponent = Integer.valueOf(rootElement.attributeValue("minSectionOpponent")).intValue();
/* 15 */     this.maxSectionOpponent = Integer.valueOf(rootElement.attributeValue("maxSectionOpponent")).intValue();
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_)
/*    */   {
/* 20 */     _os_.marshal(this.minSectionOpponent);
/* 21 */     _os_.marshal(this.maxSectionOpponent);
/* 22 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*    */   {
/* 27 */     this.minSectionOpponent = _os_.unmarshal_int();
/* 28 */     this.maxSectionOpponent = _os_.unmarshal_int();
/* 29 */     return _os_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\petarena\confbean\SectionInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */