/*    */ package mzm.gsp.huanhun;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import java.util.HashMap;
/*    */ import java.util.Map.Entry;
/*    */ 
/*    */ public class GangHelpInfo implements Marshal
/*    */ {
/*    */   public HashMap<Long, CallHelpData> role2helpdata;
/*    */   
/*    */   public GangHelpInfo()
/*    */   {
/* 14 */     this.role2helpdata = new HashMap();
/*    */   }
/*    */   
/*    */   public GangHelpInfo(HashMap<Long, CallHelpData> _role2helpdata_) {
/* 18 */     this.role2helpdata = _role2helpdata_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 22 */     for (Map.Entry<Long, CallHelpData> _e_ : this.role2helpdata.entrySet()) {
/* 23 */       if (!((CallHelpData)_e_.getValue())._validator_()) return false;
/*    */     }
/* 25 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 29 */     _os_.compact_uint32(this.role2helpdata.size());
/* 30 */     for (Map.Entry<Long, CallHelpData> _e_ : this.role2helpdata.entrySet()) {
/* 31 */       _os_.marshal(((Long)_e_.getKey()).longValue());
/* 32 */       _os_.marshal((Marshal)_e_.getValue());
/*    */     }
/* 34 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException {
/* 38 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*    */     {
/* 40 */       long _k_ = _os_.unmarshal_long();
/* 41 */       CallHelpData _v_ = new CallHelpData();
/* 42 */       _v_.unmarshal(_os_);
/* 43 */       this.role2helpdata.put(Long.valueOf(_k_), _v_);
/*    */     }
/* 45 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 49 */     if (_o1_ == this) return true;
/* 50 */     if ((_o1_ instanceof GangHelpInfo)) {
/* 51 */       GangHelpInfo _o_ = (GangHelpInfo)_o1_;
/* 52 */       if (!this.role2helpdata.equals(_o_.role2helpdata)) return false;
/* 53 */       return true;
/*    */     }
/* 55 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 59 */     int _h_ = 0;
/* 60 */     _h_ += this.role2helpdata.hashCode();
/* 61 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 65 */     StringBuilder _sb_ = new StringBuilder();
/* 66 */     _sb_.append("(");
/* 67 */     _sb_.append(this.role2helpdata).append(",");
/* 68 */     _sb_.append(")");
/* 69 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\huanhun\GangHelpInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */