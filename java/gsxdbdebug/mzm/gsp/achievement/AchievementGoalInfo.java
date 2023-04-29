/*    */ package mzm.gsp.achievement;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import java.util.ArrayList;
/*    */ 
/*    */ public class AchievementGoalInfo implements Marshal
/*    */ {
/*    */   public static final int ST_ON_GOING = 1;
/*    */   public static final int ST_FINISHED = 2;
/*    */   public static final int ST_HAND_UP = 3;
/*    */   public int state;
/*    */   public ArrayList<Integer> parameters;
/*    */   public long achieve_time;
/*    */   
/*    */   public AchievementGoalInfo()
/*    */   {
/* 18 */     this.parameters = new ArrayList();
/*    */   }
/*    */   
/*    */   public AchievementGoalInfo(int _state_, ArrayList<Integer> _parameters_, long _achieve_time_) {
/* 22 */     this.state = _state_;
/* 23 */     this.parameters = _parameters_;
/* 24 */     this.achieve_time = _achieve_time_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 28 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 32 */     _os_.marshal(this.state);
/* 33 */     _os_.compact_uint32(this.parameters.size());
/* 34 */     for (Integer _v_ : this.parameters) {
/* 35 */       _os_.marshal(_v_.intValue());
/*    */     }
/* 37 */     _os_.marshal(this.achieve_time);
/* 38 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException {
/* 42 */     this.state = _os_.unmarshal_int();
/* 43 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*    */     {
/* 45 */       int _v_ = _os_.unmarshal_int();
/* 46 */       this.parameters.add(Integer.valueOf(_v_));
/*    */     }
/* 48 */     this.achieve_time = _os_.unmarshal_long();
/* 49 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 53 */     if (_o1_ == this) return true;
/* 54 */     if ((_o1_ instanceof AchievementGoalInfo)) {
/* 55 */       AchievementGoalInfo _o_ = (AchievementGoalInfo)_o1_;
/* 56 */       if (this.state != _o_.state) return false;
/* 57 */       if (!this.parameters.equals(_o_.parameters)) return false;
/* 58 */       if (this.achieve_time != _o_.achieve_time) return false;
/* 59 */       return true;
/*    */     }
/* 61 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 65 */     int _h_ = 0;
/* 66 */     _h_ += this.state;
/* 67 */     _h_ += this.parameters.hashCode();
/* 68 */     _h_ += (int)this.achieve_time;
/* 69 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 73 */     StringBuilder _sb_ = new StringBuilder();
/* 74 */     _sb_.append("(");
/* 75 */     _sb_.append(this.state).append(",");
/* 76 */     _sb_.append(this.parameters).append(",");
/* 77 */     _sb_.append(this.achieve_time).append(",");
/* 78 */     _sb_.append(")");
/* 79 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\achievement\AchievementGoalInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */