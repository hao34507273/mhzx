/*    */ package mzm.gsp.item;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import java.util.LinkedList;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class SDoubleItemGetNotify
/*    */   extends __SDoubleItemGetNotify__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12584865;
/*    */   public LinkedList<DouobleItemBean> item_trigger_list;
/*    */   public int today_trigger_times;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12584865;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public SDoubleItemGetNotify()
/*    */   {
/* 34 */     this.item_trigger_list = new LinkedList();
/*    */   }
/*    */   
/*    */   public SDoubleItemGetNotify(LinkedList<DouobleItemBean> _item_trigger_list_, int _today_trigger_times_) {
/* 38 */     this.item_trigger_list = _item_trigger_list_;
/* 39 */     this.today_trigger_times = _today_trigger_times_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 43 */     for (DouobleItemBean _v_ : this.item_trigger_list)
/* 44 */       if (!_v_._validator_()) return false;
/* 45 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 49 */     _os_.compact_uint32(this.item_trigger_list.size());
/* 50 */     for (DouobleItemBean _v_ : this.item_trigger_list) {
/* 51 */       _os_.marshal(_v_);
/*    */     }
/* 53 */     _os_.marshal(this.today_trigger_times);
/* 54 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 58 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--) {
/* 59 */       DouobleItemBean _v_ = new DouobleItemBean();
/* 60 */       _v_.unmarshal(_os_);
/* 61 */       this.item_trigger_list.add(_v_);
/*    */     }
/* 63 */     this.today_trigger_times = _os_.unmarshal_int();
/* 64 */     if (!_validator_()) {
/* 65 */       throw new VerifyError("validator failed");
/*    */     }
/* 67 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 71 */     if (_o1_ == this) return true;
/* 72 */     if ((_o1_ instanceof SDoubleItemGetNotify)) {
/* 73 */       SDoubleItemGetNotify _o_ = (SDoubleItemGetNotify)_o1_;
/* 74 */       if (!this.item_trigger_list.equals(_o_.item_trigger_list)) return false;
/* 75 */       if (this.today_trigger_times != _o_.today_trigger_times) return false;
/* 76 */       return true;
/*    */     }
/* 78 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 82 */     int _h_ = 0;
/* 83 */     _h_ += this.item_trigger_list.hashCode();
/* 84 */     _h_ += this.today_trigger_times;
/* 85 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 89 */     StringBuilder _sb_ = new StringBuilder();
/* 90 */     _sb_.append("(");
/* 91 */     _sb_.append(this.item_trigger_list).append(",");
/* 92 */     _sb_.append(this.today_trigger_times).append(",");
/* 93 */     _sb_.append(")");
/* 94 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\item\SDoubleItemGetNotify.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */