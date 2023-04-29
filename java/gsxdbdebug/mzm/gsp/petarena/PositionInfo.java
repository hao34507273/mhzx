/*    */ package mzm.gsp.petarena;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import java.util.HashMap;
/*    */ 
/*    */ public class PositionInfo implements com.goldhuman.Common.Marshal.Marshal
/*    */ {
/*    */   public long petid;
/*    */   public int pet_fight_skill;
/*    */   public HashMap<Integer, Integer> properties;
/*    */   
/*    */   public PositionInfo()
/*    */   {
/* 14 */     this.properties = new HashMap();
/*    */   }
/*    */   
/*    */   public PositionInfo(long _petid_, int _pet_fight_skill_, HashMap<Integer, Integer> _properties_) {
/* 18 */     this.petid = _petid_;
/* 19 */     this.pet_fight_skill = _pet_fight_skill_;
/* 20 */     this.properties = _properties_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 24 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 28 */     _os_.marshal(this.petid);
/* 29 */     _os_.marshal(this.pet_fight_skill);
/* 30 */     _os_.compact_uint32(this.properties.size());
/* 31 */     for (java.util.Map.Entry<Integer, Integer> _e_ : this.properties.entrySet()) {
/* 32 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/* 33 */       _os_.marshal(((Integer)_e_.getValue()).intValue());
/*    */     }
/* 35 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException {
/* 39 */     this.petid = _os_.unmarshal_long();
/* 40 */     this.pet_fight_skill = _os_.unmarshal_int();
/* 41 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*    */     {
/* 43 */       int _k_ = _os_.unmarshal_int();
/*    */       
/* 45 */       int _v_ = _os_.unmarshal_int();
/* 46 */       this.properties.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*    */     }
/* 48 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 52 */     if (_o1_ == this) return true;
/* 53 */     if ((_o1_ instanceof PositionInfo)) {
/* 54 */       PositionInfo _o_ = (PositionInfo)_o1_;
/* 55 */       if (this.petid != _o_.petid) return false;
/* 56 */       if (this.pet_fight_skill != _o_.pet_fight_skill) return false;
/* 57 */       if (!this.properties.equals(_o_.properties)) return false;
/* 58 */       return true;
/*    */     }
/* 60 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 64 */     int _h_ = 0;
/* 65 */     _h_ += (int)this.petid;
/* 66 */     _h_ += this.pet_fight_skill;
/* 67 */     _h_ += this.properties.hashCode();
/* 68 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 72 */     StringBuilder _sb_ = new StringBuilder();
/* 73 */     _sb_.append("(");
/* 74 */     _sb_.append(this.petid).append(",");
/* 75 */     _sb_.append(this.pet_fight_skill).append(",");
/* 76 */     _sb_.append(this.properties).append(",");
/* 77 */     _sb_.append(")");
/* 78 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\petarena\PositionInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */