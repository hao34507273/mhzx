/*    */ package mzm.gsp.activity4.confbean;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import org.dom4j.Element;
/*    */ 
/*    */ public class FlowerParadeRestPos implements Marshal
/*    */ {
/*    */   public int restPosIndex;
/*    */   public int redbagId;
/*    */   
/*    */   public void loadFromXml(Element rootElement)
/*    */   {
/* 14 */     this.restPosIndex = Integer.valueOf(rootElement.attributeValue("restPosIndex")).intValue();
/* 15 */     this.redbagId = Integer.valueOf(rootElement.attributeValue("redbagId")).intValue();
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_)
/*    */   {
/* 20 */     _os_.marshal(this.restPosIndex);
/* 21 */     _os_.marshal(this.redbagId);
/* 22 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*    */   {
/* 27 */     this.restPosIndex = _os_.unmarshal_int();
/* 28 */     this.redbagId = _os_.unmarshal_int();
/* 29 */     return _os_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\activity4\confbean\FlowerParadeRestPos.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */