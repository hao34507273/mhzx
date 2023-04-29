/*    */ package mzm.gsp.wing.confbean;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import org.dom4j.Element;
/*    */ 
/*    */ public class WingDyeid2Rate implements Marshal
/*    */ {
/*    */   public int dyeid;
/*    */   public int rate;
/*    */   
/*    */   public void loadFromXml(Element rootElement)
/*    */   {
/* 14 */     this.dyeid = Integer.valueOf(rootElement.attributeValue("dyeid")).intValue();
/* 15 */     this.rate = Integer.valueOf(rootElement.attributeValue("rate")).intValue();
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_)
/*    */   {
/* 20 */     _os_.marshal(this.dyeid);
/* 21 */     _os_.marshal(this.rate);
/* 22 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*    */   {
/* 27 */     this.dyeid = _os_.unmarshal_int();
/* 28 */     this.rate = _os_.unmarshal_int();
/* 29 */     return _os_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\wing\confbean\WingDyeid2Rate.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */