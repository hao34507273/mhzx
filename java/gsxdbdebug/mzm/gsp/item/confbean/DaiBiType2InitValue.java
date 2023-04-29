/*    */ package mzm.gsp.item.confbean;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import org.dom4j.Element;
/*    */ 
/*    */ public class DaiBiType2InitValue implements Marshal
/*    */ {
/*    */   public int type;
/*    */   public int initvalue;
/*    */   
/*    */   public void loadFromXml(Element rootElement)
/*    */   {
/* 14 */     this.type = Integer.valueOf(rootElement.attributeValue("type")).intValue();
/* 15 */     this.initvalue = Integer.valueOf(rootElement.attributeValue("initvalue")).intValue();
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_)
/*    */   {
/* 20 */     _os_.marshal(this.type);
/* 21 */     _os_.marshal(this.initvalue);
/* 22 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*    */   {
/* 27 */     this.type = _os_.unmarshal_int();
/* 28 */     this.initvalue = _os_.unmarshal_int();
/* 29 */     return _os_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\item\confbean\DaiBiType2InitValue.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */