/*    */ package mzm.gsp.fight;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import java.util.HashMap;
/*    */ import java.util.Map.Entry;
/*    */ 
/*    */ public class FightTeam implements Marshal
/*    */ {
/*    */   public HashMap<Integer, FightGroup> groups;
/*    */   public int zhenfaid;
/*    */   public int zhenfalevel;
/*    */   
/*    */   public FightTeam()
/*    */   {
/* 16 */     this.groups = new HashMap();
/*    */   }
/*    */   
/*    */   public FightTeam(HashMap<Integer, FightGroup> _groups_, int _zhenfaid_, int _zhenfalevel_) {
/* 20 */     this.groups = _groups_;
/* 21 */     this.zhenfaid = _zhenfaid_;
/* 22 */     this.zhenfalevel = _zhenfalevel_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 26 */     for (Map.Entry<Integer, FightGroup> _e_ : this.groups.entrySet()) {
/* 27 */       if (!((FightGroup)_e_.getValue())._validator_()) return false;
/*    */     }
/* 29 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 33 */     _os_.compact_uint32(this.groups.size());
/* 34 */     for (Map.Entry<Integer, FightGroup> _e_ : this.groups.entrySet()) {
/* 35 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/* 36 */       _os_.marshal((Marshal)_e_.getValue());
/*    */     }
/* 38 */     _os_.marshal(this.zhenfaid);
/* 39 */     _os_.marshal(this.zhenfalevel);
/* 40 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException {
/* 44 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*    */     {
/* 46 */       int _k_ = _os_.unmarshal_int();
/* 47 */       FightGroup _v_ = new FightGroup();
/* 48 */       _v_.unmarshal(_os_);
/* 49 */       this.groups.put(Integer.valueOf(_k_), _v_);
/*    */     }
/* 51 */     this.zhenfaid = _os_.unmarshal_int();
/* 52 */     this.zhenfalevel = _os_.unmarshal_int();
/* 53 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 57 */     if (_o1_ == this) return true;
/* 58 */     if ((_o1_ instanceof FightTeam)) {
/* 59 */       FightTeam _o_ = (FightTeam)_o1_;
/* 60 */       if (!this.groups.equals(_o_.groups)) return false;
/* 61 */       if (this.zhenfaid != _o_.zhenfaid) return false;
/* 62 */       if (this.zhenfalevel != _o_.zhenfalevel) return false;
/* 63 */       return true;
/*    */     }
/* 65 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 69 */     int _h_ = 0;
/* 70 */     _h_ += this.groups.hashCode();
/* 71 */     _h_ += this.zhenfaid;
/* 72 */     _h_ += this.zhenfalevel;
/* 73 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 77 */     StringBuilder _sb_ = new StringBuilder();
/* 78 */     _sb_.append("(");
/* 79 */     _sb_.append(this.groups).append(",");
/* 80 */     _sb_.append(this.zhenfaid).append(",");
/* 81 */     _sb_.append(this.zhenfalevel).append(",");
/* 82 */     _sb_.append(")");
/* 83 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\fight\FightTeam.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */