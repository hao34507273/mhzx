/*    */ package mzm.gsp.fabao.confbean;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import org.dom4j.Element;
/*    */ 
/*    */ public class FaBaoLevelInfo implements Marshal
/*    */ {
/*    */   public int roleLv;
/*    */   public int needExp;
/*    */   
/*    */   public void loadFromXml(Element rootElement)
/*    */   {
/* 14 */     this.roleLv = Integer.valueOf(rootElement.attributeValue("roleLv")).intValue();
/* 15 */     this.needExp = Integer.valueOf(rootElement.attributeValue("needExp")).intValue();
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_)
/*    */   {
/* 20 */     _os_.marshal(this.roleLv);
/* 21 */     _os_.marshal(this.needExp);
/* 22 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*    */   {
/* 27 */     this.roleLv = _os_.unmarshal_int();
/* 28 */     this.needExp = _os_.unmarshal_int();
/* 29 */     return _os_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\fabao\confbean\FaBaoLevelInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */