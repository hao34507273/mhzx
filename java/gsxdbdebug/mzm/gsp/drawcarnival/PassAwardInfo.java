/*    */ package mzm.gsp.drawcarnival;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import java.util.LinkedList;
/*    */ 
/*    */ public class PassAwardInfo implements Marshal
/*    */ {
/*    */   public LinkedList<DrawAwardInfo> draw_award_info_list;
/*    */   
/*    */   public PassAwardInfo()
/*    */   {
/* 14 */     this.draw_award_info_list = new LinkedList();
/*    */   }
/*    */   
/*    */   public PassAwardInfo(LinkedList<DrawAwardInfo> _draw_award_info_list_) {
/* 18 */     this.draw_award_info_list = _draw_award_info_list_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 22 */     for (DrawAwardInfo _v_ : this.draw_award_info_list)
/* 23 */       if (!_v_._validator_()) return false;
/* 24 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 28 */     _os_.compact_uint32(this.draw_award_info_list.size());
/* 29 */     for (DrawAwardInfo _v_ : this.draw_award_info_list) {
/* 30 */       _os_.marshal(_v_);
/*    */     }
/* 32 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 36 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--) {
/* 37 */       DrawAwardInfo _v_ = new DrawAwardInfo();
/* 38 */       _v_.unmarshal(_os_);
/* 39 */       this.draw_award_info_list.add(_v_);
/*    */     }
/* 41 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 45 */     if (_o1_ == this) return true;
/* 46 */     if ((_o1_ instanceof PassAwardInfo)) {
/* 47 */       PassAwardInfo _o_ = (PassAwardInfo)_o1_;
/* 48 */       if (!this.draw_award_info_list.equals(_o_.draw_award_info_list)) return false;
/* 49 */       return true;
/*    */     }
/* 51 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 55 */     int _h_ = 0;
/* 56 */     _h_ += this.draw_award_info_list.hashCode();
/* 57 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 61 */     StringBuilder _sb_ = new StringBuilder();
/* 62 */     _sb_.append("(");
/* 63 */     _sb_.append(this.draw_award_info_list).append(",");
/* 64 */     _sb_.append(")");
/* 65 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\drawcarnival\PassAwardInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */