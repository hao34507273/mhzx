/*    */ package mzm.gsp.map.confbean;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import org.dom4j.Element;
/*    */ 
/*    */ public class GoldStatueInfo implements Marshal
/*    */ {
/*    */   public int cfgid;
/*    */   
/*    */   public void loadFromXml(Element rootElement)
/*    */   {
/* 13 */     this.cfgid = Integer.valueOf(rootElement.attributeValue("cfgid")).intValue();
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_)
/*    */   {
/* 18 */     _os_.marshal(this.cfgid);
/* 19 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*    */   {
/* 24 */     this.cfgid = _os_.unmarshal_int();
/* 25 */     return _os_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\map\confbean\GoldStatueInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */