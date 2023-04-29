/*    */ package mzm.gsp.feijian.confbean;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import org.dom4j.Element;
/*    */ 
/*    */ public class Pro2Value implements Marshal
/*    */ {
/*    */   public int protype;
/*    */   public int provalue;
/*    */   
/*    */   public void loadFromXml(Element rootElement)
/*    */   {
/* 14 */     this.protype = Integer.valueOf(rootElement.attributeValue("protype")).intValue();
/* 15 */     this.provalue = Integer.valueOf(rootElement.attributeValue("provalue")).intValue();
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_)
/*    */   {
/* 20 */     _os_.marshal(this.protype);
/* 21 */     _os_.marshal(this.provalue);
/* 22 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*    */   {
/* 27 */     this.protype = _os_.unmarshal_int();
/* 28 */     this.provalue = _os_.unmarshal_int();
/* 29 */     return _os_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\feijian\confbean\Pro2Value.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */