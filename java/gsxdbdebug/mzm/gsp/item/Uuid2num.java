/*    */ package mzm.gsp.item;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ 
/*    */ 
/*    */ public class Uuid2num
/*    */   implements Marshal, Comparable<Uuid2num>
/*    */ {
/*    */   public long uuid;
/*    */   public int num;
/*    */   
/*    */   public Uuid2num() {}
/*    */   
/*    */   public Uuid2num(long _uuid_, int _num_)
/*    */   {
/* 18 */     this.uuid = _uuid_;
/* 19 */     this.num = _num_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 23 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 27 */     _os_.marshal(this.uuid);
/* 28 */     _os_.marshal(this.num);
/* 29 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 33 */     this.uuid = _os_.unmarshal_long();
/* 34 */     this.num = _os_.unmarshal_int();
/* 35 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 39 */     if (_o1_ == this) return true;
/* 40 */     if ((_o1_ instanceof Uuid2num)) {
/* 41 */       Uuid2num _o_ = (Uuid2num)_o1_;
/* 42 */       if (this.uuid != _o_.uuid) return false;
/* 43 */       if (this.num != _o_.num) return false;
/* 44 */       return true;
/*    */     }
/* 46 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 50 */     int _h_ = 0;
/* 51 */     _h_ += (int)this.uuid;
/* 52 */     _h_ += this.num;
/* 53 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 57 */     StringBuilder _sb_ = new StringBuilder();
/* 58 */     _sb_.append("(");
/* 59 */     _sb_.append(this.uuid).append(",");
/* 60 */     _sb_.append(this.num).append(",");
/* 61 */     _sb_.append(")");
/* 62 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(Uuid2num _o_) {
/* 66 */     if (_o_ == this) return 0;
/* 67 */     int _c_ = 0;
/* 68 */     _c_ = Long.signum(this.uuid - _o_.uuid);
/* 69 */     if (0 != _c_) return _c_;
/* 70 */     _c_ = this.num - _o_.num;
/* 71 */     if (0 != _c_) return _c_;
/* 72 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\item\Uuid2num.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */