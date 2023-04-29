/*    */ package mzm.gsp.huanhun;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ 
/*    */ 
/*    */ public class BoxData
/*    */   implements Marshal, Comparable<BoxData>
/*    */ {
/*    */   public int itemid;
/*    */   public int num;
/*    */   public long starttime;
/*    */   
/*    */   public BoxData() {}
/*    */   
/*    */   public BoxData(int _itemid_, int _num_, long _starttime_)
/*    */   {
/* 19 */     this.itemid = _itemid_;
/* 20 */     this.num = _num_;
/* 21 */     this.starttime = _starttime_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 25 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 29 */     _os_.marshal(this.itemid);
/* 30 */     _os_.marshal(this.num);
/* 31 */     _os_.marshal(this.starttime);
/* 32 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 36 */     this.itemid = _os_.unmarshal_int();
/* 37 */     this.num = _os_.unmarshal_int();
/* 38 */     this.starttime = _os_.unmarshal_long();
/* 39 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 43 */     if (_o1_ == this) return true;
/* 44 */     if ((_o1_ instanceof BoxData)) {
/* 45 */       BoxData _o_ = (BoxData)_o1_;
/* 46 */       if (this.itemid != _o_.itemid) return false;
/* 47 */       if (this.num != _o_.num) return false;
/* 48 */       if (this.starttime != _o_.starttime) return false;
/* 49 */       return true;
/*    */     }
/* 51 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 55 */     int _h_ = 0;
/* 56 */     _h_ += this.itemid;
/* 57 */     _h_ += this.num;
/* 58 */     _h_ += (int)this.starttime;
/* 59 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 63 */     StringBuilder _sb_ = new StringBuilder();
/* 64 */     _sb_.append("(");
/* 65 */     _sb_.append(this.itemid).append(",");
/* 66 */     _sb_.append(this.num).append(",");
/* 67 */     _sb_.append(this.starttime).append(",");
/* 68 */     _sb_.append(")");
/* 69 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(BoxData _o_) {
/* 73 */     if (_o_ == this) return 0;
/* 74 */     int _c_ = 0;
/* 75 */     _c_ = this.itemid - _o_.itemid;
/* 76 */     if (0 != _c_) return _c_;
/* 77 */     _c_ = this.num - _o_.num;
/* 78 */     if (0 != _c_) return _c_;
/* 79 */     _c_ = Long.signum(this.starttime - _o_.starttime);
/* 80 */     if (0 != _c_) return _c_;
/* 81 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\huanhun\BoxData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */