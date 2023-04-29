/*    */ package mzm.gsp.shitu;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import java.util.HashSet;
/*    */ 
/*    */ public class ShiTuActiveInfo implements Marshal
/*    */ {
/*    */   public long role_id;
/*    */   public int relation_start_time;
/*    */   public int active_value;
/*    */   public HashSet<Integer> award_active_index_id_set;
/*    */   
/*    */   public ShiTuActiveInfo()
/*    */   {
/* 17 */     this.award_active_index_id_set = new HashSet();
/*    */   }
/*    */   
/*    */   public ShiTuActiveInfo(long _role_id_, int _relation_start_time_, int _active_value_, HashSet<Integer> _award_active_index_id_set_) {
/* 21 */     this.role_id = _role_id_;
/* 22 */     this.relation_start_time = _relation_start_time_;
/* 23 */     this.active_value = _active_value_;
/* 24 */     this.award_active_index_id_set = _award_active_index_id_set_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 28 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 32 */     _os_.marshal(this.role_id);
/* 33 */     _os_.marshal(this.relation_start_time);
/* 34 */     _os_.marshal(this.active_value);
/* 35 */     _os_.compact_uint32(this.award_active_index_id_set.size());
/* 36 */     for (Integer _v_ : this.award_active_index_id_set) {
/* 37 */       _os_.marshal(_v_.intValue());
/*    */     }
/* 39 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 43 */     this.role_id = _os_.unmarshal_long();
/* 44 */     this.relation_start_time = _os_.unmarshal_int();
/* 45 */     this.active_value = _os_.unmarshal_int();
/* 46 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*    */     {
/* 48 */       int _v_ = _os_.unmarshal_int();
/* 49 */       this.award_active_index_id_set.add(Integer.valueOf(_v_));
/*    */     }
/* 51 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 55 */     if (_o1_ == this) return true;
/* 56 */     if ((_o1_ instanceof ShiTuActiveInfo)) {
/* 57 */       ShiTuActiveInfo _o_ = (ShiTuActiveInfo)_o1_;
/* 58 */       if (this.role_id != _o_.role_id) return false;
/* 59 */       if (this.relation_start_time != _o_.relation_start_time) return false;
/* 60 */       if (this.active_value != _o_.active_value) return false;
/* 61 */       if (!this.award_active_index_id_set.equals(_o_.award_active_index_id_set)) return false;
/* 62 */       return true;
/*    */     }
/* 64 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 68 */     int _h_ = 0;
/* 69 */     _h_ += (int)this.role_id;
/* 70 */     _h_ += this.relation_start_time;
/* 71 */     _h_ += this.active_value;
/* 72 */     _h_ += this.award_active_index_id_set.hashCode();
/* 73 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 77 */     StringBuilder _sb_ = new StringBuilder();
/* 78 */     _sb_.append("(");
/* 79 */     _sb_.append(this.role_id).append(",");
/* 80 */     _sb_.append(this.relation_start_time).append(",");
/* 81 */     _sb_.append(this.active_value).append(",");
/* 82 */     _sb_.append(this.award_active_index_id_set).append(",");
/* 83 */     _sb_.append(")");
/* 84 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\shitu\ShiTuActiveInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */