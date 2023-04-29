/*    */ package mzm.gsp.crossbattle.confbean;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import org.dom4j.Element;
/*    */ 
/*    */ public class SecondPlaceBuffBean implements Marshal
/*    */ {
/*    */   public int second_place_buff;
/*    */   public int second_place_buff_ratio;
/*    */   
/*    */   public void loadFromXml(Element rootElement)
/*    */   {
/* 14 */     this.second_place_buff = Integer.valueOf(rootElement.attributeValue("second_place_buff")).intValue();
/* 15 */     this.second_place_buff_ratio = Integer.valueOf(rootElement.attributeValue("second_place_buff_ratio")).intValue();
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_)
/*    */   {
/* 20 */     _os_.marshal(this.second_place_buff);
/* 21 */     _os_.marshal(this.second_place_buff_ratio);
/* 22 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*    */   {
/* 27 */     this.second_place_buff = _os_.unmarshal_int();
/* 28 */     this.second_place_buff_ratio = _os_.unmarshal_int();
/* 29 */     return _os_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossbattle\confbean\SecondPlaceBuffBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */