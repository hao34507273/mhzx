/*    */ package mzm.gsp.qingyunzhi.confbean;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import org.dom4j.Element;
/*    */ 
/*    */ public class dlgCfg implements Marshal
/*    */ {
/*    */   public int dlgNpcId;
/*    */   public int dlg;
/*    */   
/*    */   public void loadFromXml(Element rootElement)
/*    */   {
/* 14 */     this.dlgNpcId = Integer.valueOf(rootElement.attributeValue("dlgNpcId")).intValue();
/* 15 */     this.dlg = Integer.valueOf(rootElement.attributeValue("dlg")).intValue();
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_)
/*    */   {
/* 20 */     _os_.marshal(this.dlgNpcId);
/* 21 */     _os_.marshal(this.dlg);
/* 22 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*    */   {
/* 27 */     this.dlgNpcId = _os_.unmarshal_int();
/* 28 */     this.dlg = _os_.unmarshal_int();
/* 29 */     return _os_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\qingyunzhi\confbean\dlgCfg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */