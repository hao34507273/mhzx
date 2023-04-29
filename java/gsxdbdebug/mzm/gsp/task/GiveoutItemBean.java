/*    */ package mzm.gsp.task;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ 
/*    */ public class GiveoutItemBean implements Marshal, Comparable<GiveoutItemBean>
/*    */ {
/*    */   public long uuid;
/*    */   public int num;
/*    */   
/*    */   public GiveoutItemBean() {}
/*    */   
/*    */   public GiveoutItemBean(long _uuid_, int _num_)
/*    */   {
/* 16 */     this.uuid = _uuid_;
/* 17 */     this.num = _num_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 21 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 25 */     _os_.marshal(this.uuid);
/* 26 */     _os_.marshal(this.num);
/* 27 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 31 */     this.uuid = _os_.unmarshal_long();
/* 32 */     this.num = _os_.unmarshal_int();
/* 33 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 37 */     if (_o1_ == this) return true;
/* 38 */     if ((_o1_ instanceof GiveoutItemBean)) {
/* 39 */       GiveoutItemBean _o_ = (GiveoutItemBean)_o1_;
/* 40 */       if (this.uuid != _o_.uuid) return false;
/* 41 */       if (this.num != _o_.num) return false;
/* 42 */       return true;
/*    */     }
/* 44 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 48 */     int _h_ = 0;
/* 49 */     _h_ += (int)this.uuid;
/* 50 */     _h_ += this.num;
/* 51 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 55 */     StringBuilder _sb_ = new StringBuilder();
/* 56 */     _sb_.append("(");
/* 57 */     _sb_.append(this.uuid).append(",");
/* 58 */     _sb_.append(this.num).append(",");
/* 59 */     _sb_.append(")");
/* 60 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(GiveoutItemBean _o_) {
/* 64 */     if (_o_ == this) return 0;
/* 65 */     int _c_ = 0;
/* 66 */     _c_ = Long.signum(this.uuid - _o_.uuid);
/* 67 */     if (0 != _c_) return _c_;
/* 68 */     _c_ = this.num - _o_.num;
/* 69 */     if (0 != _c_) return _c_;
/* 70 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\task\GiveoutItemBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */