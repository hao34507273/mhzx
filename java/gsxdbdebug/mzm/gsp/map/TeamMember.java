/*    */ package mzm.gsp.map;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import com.goldhuman.Common.Octets;
/*    */ import java.util.HashMap;
/*    */ 
/*    */ public class TeamMember implements com.goldhuman.Common.Marshal.Marshal
/*    */ {
/*    */   public static final int KEY_PET = 1;
/*    */   public static final int KEY_CHILDREN = 2;
/*    */   public long roleid;
/*    */   public Octets modelinfo;
/*    */   public HashMap<Integer, Octets> models;
/*    */   
/*    */   public TeamMember()
/*    */   {
/* 17 */     this.modelinfo = new Octets();
/* 18 */     this.models = new HashMap();
/*    */   }
/*    */   
/*    */   public TeamMember(long _roleid_, Octets _modelinfo_, HashMap<Integer, Octets> _models_) {
/* 22 */     this.roleid = _roleid_;
/* 23 */     this.modelinfo = _modelinfo_;
/* 24 */     this.models = _models_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 28 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 32 */     _os_.marshal(this.roleid);
/* 33 */     _os_.marshal(this.modelinfo);
/* 34 */     _os_.compact_uint32(this.models.size());
/* 35 */     for (java.util.Map.Entry<Integer, Octets> _e_ : this.models.entrySet()) {
/* 36 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/* 37 */       _os_.marshal((Octets)_e_.getValue());
/*    */     }
/* 39 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException {
/* 43 */     this.roleid = _os_.unmarshal_long();
/* 44 */     this.modelinfo = _os_.unmarshal_Octets();
/* 45 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*    */     {
/* 47 */       int _k_ = _os_.unmarshal_int();
/*    */       
/* 49 */       Octets _v_ = _os_.unmarshal_Octets();
/* 50 */       this.models.put(Integer.valueOf(_k_), _v_);
/*    */     }
/* 52 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 56 */     if (_o1_ == this) return true;
/* 57 */     if ((_o1_ instanceof TeamMember)) {
/* 58 */       TeamMember _o_ = (TeamMember)_o1_;
/* 59 */       if (this.roleid != _o_.roleid) return false;
/* 60 */       if (!this.modelinfo.equals(_o_.modelinfo)) return false;
/* 61 */       if (!this.models.equals(_o_.models)) return false;
/* 62 */       return true;
/*    */     }
/* 64 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 68 */     int _h_ = 0;
/* 69 */     _h_ += (int)this.roleid;
/* 70 */     _h_ += this.modelinfo.hashCode();
/* 71 */     _h_ += this.models.hashCode();
/* 72 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 76 */     StringBuilder _sb_ = new StringBuilder();
/* 77 */     _sb_.append("(");
/* 78 */     _sb_.append(this.roleid).append(",");
/* 79 */     _sb_.append("B").append(this.modelinfo.size()).append(",");
/* 80 */     _sb_.append(this.models).append(",");
/* 81 */     _sb_.append(")");
/* 82 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\map\TeamMember.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */