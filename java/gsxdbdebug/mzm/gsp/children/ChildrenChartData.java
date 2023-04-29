/*    */ package mzm.gsp.children;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import com.goldhuman.Common.Octets;
/*    */ 
/*    */ public class ChildrenChartData implements Marshal
/*    */ {
/*    */   public int rank;
/*    */   public long child_id;
/*    */   public long role_id;
/*    */   public Octets child_name;
/*    */   public Octets role_name;
/*    */   public int rating;
/*    */   
/*    */   public ChildrenChartData()
/*    */   {
/* 19 */     this.child_name = new Octets();
/* 20 */     this.role_name = new Octets();
/*    */   }
/*    */   
/*    */   public ChildrenChartData(int _rank_, long _child_id_, long _role_id_, Octets _child_name_, Octets _role_name_, int _rating_) {
/* 24 */     this.rank = _rank_;
/* 25 */     this.child_id = _child_id_;
/* 26 */     this.role_id = _role_id_;
/* 27 */     this.child_name = _child_name_;
/* 28 */     this.role_name = _role_name_;
/* 29 */     this.rating = _rating_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 33 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 37 */     _os_.marshal(this.rank);
/* 38 */     _os_.marshal(this.child_id);
/* 39 */     _os_.marshal(this.role_id);
/* 40 */     _os_.marshal(this.child_name);
/* 41 */     _os_.marshal(this.role_name);
/* 42 */     _os_.marshal(this.rating);
/* 43 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 47 */     this.rank = _os_.unmarshal_int();
/* 48 */     this.child_id = _os_.unmarshal_long();
/* 49 */     this.role_id = _os_.unmarshal_long();
/* 50 */     this.child_name = _os_.unmarshal_Octets();
/* 51 */     this.role_name = _os_.unmarshal_Octets();
/* 52 */     this.rating = _os_.unmarshal_int();
/* 53 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 57 */     if (_o1_ == this) return true;
/* 58 */     if ((_o1_ instanceof ChildrenChartData)) {
/* 59 */       ChildrenChartData _o_ = (ChildrenChartData)_o1_;
/* 60 */       if (this.rank != _o_.rank) return false;
/* 61 */       if (this.child_id != _o_.child_id) return false;
/* 62 */       if (this.role_id != _o_.role_id) return false;
/* 63 */       if (!this.child_name.equals(_o_.child_name)) return false;
/* 64 */       if (!this.role_name.equals(_o_.role_name)) return false;
/* 65 */       if (this.rating != _o_.rating) return false;
/* 66 */       return true;
/*    */     }
/* 68 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 72 */     int _h_ = 0;
/* 73 */     _h_ += this.rank;
/* 74 */     _h_ += (int)this.child_id;
/* 75 */     _h_ += (int)this.role_id;
/* 76 */     _h_ += this.child_name.hashCode();
/* 77 */     _h_ += this.role_name.hashCode();
/* 78 */     _h_ += this.rating;
/* 79 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 83 */     StringBuilder _sb_ = new StringBuilder();
/* 84 */     _sb_.append("(");
/* 85 */     _sb_.append(this.rank).append(",");
/* 86 */     _sb_.append(this.child_id).append(",");
/* 87 */     _sb_.append(this.role_id).append(",");
/* 88 */     _sb_.append("B").append(this.child_name.size()).append(",");
/* 89 */     _sb_.append("B").append(this.role_name.size()).append(",");
/* 90 */     _sb_.append(this.rating).append(",");
/* 91 */     _sb_.append(")");
/* 92 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\children\ChildrenChartData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */