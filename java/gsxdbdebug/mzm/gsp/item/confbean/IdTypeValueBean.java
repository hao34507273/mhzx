/*    */ package mzm.gsp.item.confbean;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import org.dom4j.Element;
/*    */ 
/*    */ public class IdTypeValueBean implements Marshal
/*    */ {
/*    */   public int idtype;
/*    */   public int idvalue;
/*    */   
/*    */   public void loadFromXml(Element rootElement)
/*    */   {
/* 14 */     this.idtype = Integer.valueOf(rootElement.attributeValue("idtype")).intValue();
/* 15 */     this.idvalue = Integer.valueOf(rootElement.attributeValue("idvalue")).intValue();
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_)
/*    */   {
/* 20 */     _os_.marshal(this.idtype);
/* 21 */     _os_.marshal(this.idvalue);
/* 22 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*    */   {
/* 27 */     this.idtype = _os_.unmarshal_int();
/* 28 */     this.idvalue = _os_.unmarshal_int();
/* 29 */     return _os_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\item\confbean\IdTypeValueBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */