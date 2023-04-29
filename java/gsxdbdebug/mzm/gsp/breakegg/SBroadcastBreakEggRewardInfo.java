/*     */ package mzm.gsp.breakegg;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.util.ArrayList;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class SBroadcastBreakEggRewardInfo
/*     */   extends __SBroadcastBreakEggRewardInfo__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12623372;
/*     */   public int activity_id;
/*     */   public long inviter_id;
/*     */   public String inviter_name;
/*     */   public ArrayList<BreakEggInfo> break_egg_info;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12623372;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public SBroadcastBreakEggRewardInfo()
/*     */   {
/*  36 */     this.inviter_name = "";
/*  37 */     this.break_egg_info = new ArrayList();
/*     */   }
/*     */   
/*     */   public SBroadcastBreakEggRewardInfo(int _activity_id_, long _inviter_id_, String _inviter_name_, ArrayList<BreakEggInfo> _break_egg_info_) {
/*  41 */     this.activity_id = _activity_id_;
/*  42 */     this.inviter_id = _inviter_id_;
/*  43 */     this.inviter_name = _inviter_name_;
/*  44 */     this.break_egg_info = _break_egg_info_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  48 */     for (BreakEggInfo _v_ : this.break_egg_info)
/*  49 */       if (!_v_._validator_()) return false;
/*  50 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  54 */     _os_.marshal(this.activity_id);
/*  55 */     _os_.marshal(this.inviter_id);
/*  56 */     _os_.marshal(this.inviter_name, "UTF-16LE");
/*  57 */     _os_.compact_uint32(this.break_egg_info.size());
/*  58 */     for (BreakEggInfo _v_ : this.break_egg_info) {
/*  59 */       _os_.marshal(_v_);
/*     */     }
/*  61 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  65 */     this.activity_id = _os_.unmarshal_int();
/*  66 */     this.inviter_id = _os_.unmarshal_long();
/*  67 */     this.inviter_name = _os_.unmarshal_String("UTF-16LE");
/*  68 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--) {
/*  69 */       BreakEggInfo _v_ = new BreakEggInfo();
/*  70 */       _v_.unmarshal(_os_);
/*  71 */       this.break_egg_info.add(_v_);
/*     */     }
/*  73 */     if (!_validator_()) {
/*  74 */       throw new VerifyError("validator failed");
/*     */     }
/*  76 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  80 */     if (_o1_ == this) return true;
/*  81 */     if ((_o1_ instanceof SBroadcastBreakEggRewardInfo)) {
/*  82 */       SBroadcastBreakEggRewardInfo _o_ = (SBroadcastBreakEggRewardInfo)_o1_;
/*  83 */       if (this.activity_id != _o_.activity_id) return false;
/*  84 */       if (this.inviter_id != _o_.inviter_id) return false;
/*  85 */       if (!this.inviter_name.equals(_o_.inviter_name)) return false;
/*  86 */       if (!this.break_egg_info.equals(_o_.break_egg_info)) return false;
/*  87 */       return true;
/*     */     }
/*  89 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  93 */     int _h_ = 0;
/*  94 */     _h_ += this.activity_id;
/*  95 */     _h_ += (int)this.inviter_id;
/*  96 */     _h_ += this.inviter_name.hashCode();
/*  97 */     _h_ += this.break_egg_info.hashCode();
/*  98 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/* 102 */     StringBuilder _sb_ = new StringBuilder();
/* 103 */     _sb_.append("(");
/* 104 */     _sb_.append(this.activity_id).append(",");
/* 105 */     _sb_.append(this.inviter_id).append(",");
/* 106 */     _sb_.append("T").append(this.inviter_name.length()).append(",");
/* 107 */     _sb_.append(this.break_egg_info).append(",");
/* 108 */     _sb_.append(")");
/* 109 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\breakegg\SBroadcastBreakEggRewardInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */