/*    */ package mzm.gsp.breakegg;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import java.util.HashMap;
/*    */ import java.util.Map.Entry;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class SSynBreakEggRewardInfo
/*    */   extends __SSynBreakEggRewardInfo__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12623363;
/*    */   public int activity_id;
/*    */   public HashMap<Integer, BreakEggInfo> index2break_egg_info;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12623363;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public SSynBreakEggRewardInfo()
/*    */   {
/* 34 */     this.index2break_egg_info = new HashMap();
/*    */   }
/*    */   
/*    */   public SSynBreakEggRewardInfo(int _activity_id_, HashMap<Integer, BreakEggInfo> _index2break_egg_info_) {
/* 38 */     this.activity_id = _activity_id_;
/* 39 */     this.index2break_egg_info = _index2break_egg_info_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 43 */     for (Map.Entry<Integer, BreakEggInfo> _e_ : this.index2break_egg_info.entrySet()) {
/* 44 */       if (!((BreakEggInfo)_e_.getValue())._validator_()) return false;
/*    */     }
/* 46 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 50 */     _os_.marshal(this.activity_id);
/* 51 */     _os_.compact_uint32(this.index2break_egg_info.size());
/* 52 */     for (Map.Entry<Integer, BreakEggInfo> _e_ : this.index2break_egg_info.entrySet()) {
/* 53 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/* 54 */       _os_.marshal((Marshal)_e_.getValue());
/*    */     }
/* 56 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 60 */     this.activity_id = _os_.unmarshal_int();
/* 61 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*    */     {
/* 63 */       int _k_ = _os_.unmarshal_int();
/* 64 */       BreakEggInfo _v_ = new BreakEggInfo();
/* 65 */       _v_.unmarshal(_os_);
/* 66 */       this.index2break_egg_info.put(Integer.valueOf(_k_), _v_);
/*    */     }
/* 68 */     if (!_validator_()) {
/* 69 */       throw new VerifyError("validator failed");
/*    */     }
/* 71 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 75 */     if (_o1_ == this) return true;
/* 76 */     if ((_o1_ instanceof SSynBreakEggRewardInfo)) {
/* 77 */       SSynBreakEggRewardInfo _o_ = (SSynBreakEggRewardInfo)_o1_;
/* 78 */       if (this.activity_id != _o_.activity_id) return false;
/* 79 */       if (!this.index2break_egg_info.equals(_o_.index2break_egg_info)) return false;
/* 80 */       return true;
/*    */     }
/* 82 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 86 */     int _h_ = 0;
/* 87 */     _h_ += this.activity_id;
/* 88 */     _h_ += this.index2break_egg_info.hashCode();
/* 89 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 93 */     StringBuilder _sb_ = new StringBuilder();
/* 94 */     _sb_.append("(");
/* 95 */     _sb_.append(this.activity_id).append(",");
/* 96 */     _sb_.append(this.index2break_egg_info).append(",");
/* 97 */     _sb_.append(")");
/* 98 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\breakegg\SSynBreakEggRewardInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */