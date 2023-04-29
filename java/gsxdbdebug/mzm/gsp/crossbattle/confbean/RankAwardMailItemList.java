/*    */ package mzm.gsp.crossbattle.confbean;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import java.util.ArrayList;
/*    */ import org.dom4j.Element;
/*    */ 
/*    */ public class RankAwardMailItemList implements com.goldhuman.Common.Marshal.Marshal
/*    */ {
/*    */   public int award_item_mail_cfg_id;
/* 10 */   public ArrayList<RankAwardMailItemBean> award_item_list = new ArrayList();
/*    */   
/*    */   public void loadFromXml(Element rootElement)
/*    */   {
/* 14 */     this.award_item_mail_cfg_id = Integer.valueOf(rootElement.attributeValue("award_item_mail_cfg_id")).intValue();
/*    */     
/* 16 */     Element collectionElement = util.XmlHelper.getVariableElement(rootElement, "award_item_list");
/* 17 */     if (collectionElement == null)
/*    */     {
/* 19 */       throw new RuntimeException("collection type element does not find");
/*    */     }
/*    */     
/* 22 */     java.util.List<?> _nodeList = collectionElement.elements();
/* 23 */     int _len = _nodeList.size();
/* 24 */     for (int i = 0; i < _len; i++)
/*    */     {
/* 26 */       Element elem = (Element)_nodeList.get(i);
/* 27 */       if (elem.getName().equalsIgnoreCase("mzm.gsp.crossbattle.confbean.RankAwardMailItemBean"))
/*    */       {
/*    */         RankAwardMailItemBean _v_;
/*    */         
/*    */ 
/*    */         try
/*    */         {
/* 34 */           _v_ = new RankAwardMailItemBean();
/* 35 */           _v_.loadFromXml(elem);
/*    */         }
/*    */         catch (Exception e)
/*    */         {
/*    */           continue;
/*    */         }
/*    */         
/* 42 */         this.award_item_list.add(_v_);
/*    */       }
/*    */     }
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_)
/*    */   {
/* 49 */     _os_.marshal(this.award_item_mail_cfg_id);
/* 50 */     _os_.compact_uint32(this.award_item_list.size());
/* 51 */     for (RankAwardMailItemBean _v_ : this.award_item_list)
/*    */     {
/* 53 */       _os_.marshal(_v_);
/*    */     }
/* 55 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*    */   {
/* 60 */     this.award_item_mail_cfg_id = _os_.unmarshal_int();
/* 61 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*    */     {
/*    */ 
/* 64 */       RankAwardMailItemBean _v_ = new RankAwardMailItemBean();
/* 65 */       _v_.unmarshal(_os_);
/* 66 */       this.award_item_list.add(_v_);
/*    */     }
/* 68 */     return _os_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossbattle\confbean\RankAwardMailItemList.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */