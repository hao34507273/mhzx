/*      */ package xbean.__;
/*      */ 
/*      */ import com.goldhuman.Common.Marshal.OctetsStream;
/*      */ import java.util.HashMap;
/*      */ import java.util.HashSet;
/*      */ import java.util.Map;
/*      */ import java.util.Map.Entry;
/*      */ import java.util.Set;
/*      */ import ppbio.CodedInputStream;
/*      */ import ppbio.CodedOutputStream;
/*      */ import ppbio.InvalidProtocolBufferException;
/*      */ import xdb.XBean;
/*      */ import xdb.util.SetX;
/*      */ 
/*      */ public final class ActivityAchievementInfo extends XBean implements xbean.ActivityAchievementInfo
/*      */ {
/*      */   private HashMap<Integer, xbean.AchievementInfo> goal_info;
/*      */   private int score_value;
/*      */   private SetX<Integer> aleardy_awarded_score;
/*      */   private HashMap<Long, String> activity_parameters_extra;
/*      */   
/*      */   public void _reset_unsafe_()
/*      */   {
/*   24 */     this.goal_info.clear();
/*   25 */     this.score_value = 0;
/*   26 */     this.aleardy_awarded_score.clear();
/*   27 */     this.activity_parameters_extra.clear();
/*      */   }
/*      */   
/*      */   ActivityAchievementInfo(int __, XBean _xp_, String _vn_)
/*      */   {
/*   32 */     super(_xp_, _vn_);
/*   33 */     this.goal_info = new HashMap();
/*   34 */     this.aleardy_awarded_score = new SetX();
/*   35 */     this.activity_parameters_extra = new HashMap();
/*      */   }
/*      */   
/*      */   public ActivityAchievementInfo()
/*      */   {
/*   40 */     this(0, null, null);
/*      */   }
/*      */   
/*      */   public ActivityAchievementInfo(ActivityAchievementInfo _o_)
/*      */   {
/*   45 */     this(_o_, null, null);
/*      */   }
/*      */   
/*      */   ActivityAchievementInfo(xbean.ActivityAchievementInfo _o1_, XBean _xp_, String _vn_)
/*      */   {
/*   50 */     super(_xp_, _vn_);
/*   51 */     if ((_o1_ instanceof ActivityAchievementInfo)) { assign((ActivityAchievementInfo)_o1_);
/*   52 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*   53 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*   54 */       throw new UnsupportedOperationException();
/*      */     }
/*      */   }
/*      */   
/*      */   private void assign(ActivityAchievementInfo _o_) {
/*   59 */     _o_._xdb_verify_unsafe_();
/*   60 */     this.goal_info = new HashMap();
/*   61 */     for (Map.Entry<Integer, xbean.AchievementInfo> _e_ : _o_.goal_info.entrySet())
/*   62 */       this.goal_info.put(_e_.getKey(), new AchievementInfo((xbean.AchievementInfo)_e_.getValue(), this, "goal_info"));
/*   63 */     this.score_value = _o_.score_value;
/*   64 */     this.aleardy_awarded_score = new SetX();
/*   65 */     this.aleardy_awarded_score.addAll(_o_.aleardy_awarded_score);
/*   66 */     this.activity_parameters_extra = new HashMap();
/*   67 */     for (Map.Entry<Long, String> _e_ : _o_.activity_parameters_extra.entrySet()) {
/*   68 */       this.activity_parameters_extra.put(_e_.getKey(), _e_.getValue());
/*      */     }
/*      */   }
/*      */   
/*      */   private void assign(Data _o_) {
/*   73 */     this.goal_info = new HashMap();
/*   74 */     for (Map.Entry<Integer, xbean.AchievementInfo> _e_ : _o_.goal_info.entrySet())
/*   75 */       this.goal_info.put(_e_.getKey(), new AchievementInfo((xbean.AchievementInfo)_e_.getValue(), this, "goal_info"));
/*   76 */     this.score_value = _o_.score_value;
/*   77 */     this.aleardy_awarded_score = new SetX();
/*   78 */     this.aleardy_awarded_score.addAll(_o_.aleardy_awarded_score);
/*   79 */     this.activity_parameters_extra = new HashMap();
/*   80 */     for (Map.Entry<Long, String> _e_ : _o_.activity_parameters_extra.entrySet()) {
/*   81 */       this.activity_parameters_extra.put(_e_.getKey(), _e_.getValue());
/*      */     }
/*      */   }
/*      */   
/*      */   public final OctetsStream marshal(OctetsStream _os_)
/*      */   {
/*   87 */     _xdb_verify_unsafe_();
/*   88 */     _os_.compact_uint32(this.goal_info.size());
/*   89 */     for (Map.Entry<Integer, xbean.AchievementInfo> _e_ : this.goal_info.entrySet())
/*      */     {
/*   91 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/*   92 */       ((xbean.AchievementInfo)_e_.getValue()).marshal(_os_);
/*      */     }
/*   94 */     _os_.marshal(this.score_value);
/*   95 */     _os_.compact_uint32(this.aleardy_awarded_score.size());
/*   96 */     for (Integer _v_ : this.aleardy_awarded_score)
/*      */     {
/*   98 */       _os_.marshal(_v_.intValue());
/*      */     }
/*  100 */     _os_.compact_uint32(this.activity_parameters_extra.size());
/*  101 */     for (Map.Entry<Long, String> _e_ : this.activity_parameters_extra.entrySet())
/*      */     {
/*  103 */       _os_.marshal(((Long)_e_.getKey()).longValue());
/*  104 */       _os_.marshal((String)_e_.getValue(), "UTF-16LE");
/*      */     }
/*  106 */     return _os_;
/*      */   }
/*      */   
/*      */   public final OctetsStream unmarshal(OctetsStream _os_)
/*      */     throws com.goldhuman.Common.Marshal.MarshalException
/*      */   {
/*  112 */     _xdb_verify_unsafe_();
/*      */     
/*  114 */     int size = _os_.uncompact_uint32();
/*  115 */     if (size >= 12)
/*      */     {
/*  117 */       this.goal_info = new HashMap(size * 2);
/*      */     }
/*  119 */     for (; size > 0; size--)
/*      */     {
/*  121 */       int _k_ = 0;
/*  122 */       _k_ = _os_.unmarshal_int();
/*  123 */       xbean.AchievementInfo _v_ = new AchievementInfo(0, this, "goal_info");
/*  124 */       _v_.unmarshal(_os_);
/*  125 */       this.goal_info.put(Integer.valueOf(_k_), _v_);
/*      */     }
/*      */     
/*  128 */     this.score_value = _os_.unmarshal_int();
/*  129 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*      */     {
/*  131 */       int _v_ = 0;
/*  132 */       _v_ = _os_.unmarshal_int();
/*  133 */       this.aleardy_awarded_score.add(Integer.valueOf(_v_));
/*      */     }
/*      */     
/*  136 */     int size = _os_.uncompact_uint32();
/*  137 */     if (size >= 12)
/*      */     {
/*  139 */       this.activity_parameters_extra = new HashMap(size * 2);
/*      */     }
/*  141 */     for (; size > 0; size--)
/*      */     {
/*  143 */       long _k_ = 0L;
/*  144 */       _k_ = _os_.unmarshal_long();
/*  145 */       String _v_ = "";
/*  146 */       _v_ = _os_.unmarshal_String("UTF-16LE");
/*  147 */       this.activity_parameters_extra.put(Long.valueOf(_k_), _v_);
/*      */     }
/*      */     
/*  150 */     return _os_;
/*      */   }
/*      */   
/*      */ 
/*      */   public int getSerializedSize()
/*      */   {
/*  156 */     _xdb_verify_unsafe_();
/*  157 */     int _size_ = 0;
/*  158 */     for (Map.Entry<Integer, xbean.AchievementInfo> _e_ : this.goal_info.entrySet())
/*      */     {
/*  160 */       _size_ += CodedOutputStream.computeInt32Size(1, ((Integer)_e_.getKey()).intValue());
/*  161 */       _size_ += CodedOutputStream.computeMessageSize(1, (ppbio.Message)_e_.getValue());
/*      */     }
/*  163 */     _size_ += CodedOutputStream.computeInt32Size(2, this.score_value);
/*  164 */     for (Integer _v_ : this.aleardy_awarded_score)
/*      */     {
/*  166 */       _size_ += CodedOutputStream.computeInt32Size(3, _v_.intValue());
/*      */     }
/*  168 */     for (Map.Entry<Long, String> _e_ : this.activity_parameters_extra.entrySet())
/*      */     {
/*  170 */       _size_ += CodedOutputStream.computeInt64Size(4, ((Long)_e_.getKey()).longValue());
/*      */       try
/*      */       {
/*  173 */         _size_ += CodedOutputStream.computeBytesSize(4, ppbio.ByteString.copyFrom((String)_e_.getValue(), "UTF-16LE"));
/*      */       }
/*      */       catch (java.io.UnsupportedEncodingException e)
/*      */       {
/*  177 */         throw new RuntimeException("UTF-16LE not supported?", e);
/*      */       }
/*      */     }
/*  180 */     return _size_;
/*      */   }
/*      */   
/*      */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */     throws InvalidProtocolBufferException
/*      */   {
/*  186 */     _xdb_verify_unsafe_();
/*      */     try
/*      */     {
/*  189 */       for (Map.Entry<Integer, xbean.AchievementInfo> _e_ : this.goal_info.entrySet())
/*      */       {
/*  191 */         _output_.writeInt32(1, ((Integer)_e_.getKey()).intValue());
/*  192 */         _output_.writeMessage(1, (ppbio.Message)_e_.getValue());
/*      */       }
/*  194 */       _output_.writeInt32(2, this.score_value);
/*  195 */       for (Integer _v_ : this.aleardy_awarded_score)
/*      */       {
/*  197 */         _output_.writeInt32(3, _v_.intValue());
/*      */       }
/*  199 */       for (Map.Entry<Long, String> _e_ : this.activity_parameters_extra.entrySet())
/*      */       {
/*  201 */         _output_.writeInt64(4, ((Long)_e_.getKey()).longValue());
/*  202 */         _output_.writeBytes(4, ppbio.ByteString.copyFrom((String)_e_.getValue(), "UTF-16LE"));
/*      */       }
/*      */     }
/*      */     catch (java.io.IOException e)
/*      */     {
/*  207 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */     }
/*  209 */     return _output_;
/*      */   }
/*      */   
/*      */   public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */     throws InvalidProtocolBufferException
/*      */   {
/*  215 */     _xdb_verify_unsafe_();
/*      */     try
/*      */     {
/*  218 */       boolean done = false;
/*  219 */       while (!done)
/*      */       {
/*  221 */         int tag = _input_.readTag();
/*  222 */         switch (tag)
/*      */         {
/*      */ 
/*      */         case 0: 
/*  226 */           done = true;
/*  227 */           break;
/*      */         
/*      */ 
/*      */         case 8: 
/*  231 */           int _k_ = 0;
/*  232 */           _k_ = _input_.readInt32();
/*  233 */           int readTag = _input_.readTag();
/*  234 */           if (10 != readTag)
/*      */           {
/*  236 */             throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*      */           }
/*  238 */           xbean.AchievementInfo _v_ = new AchievementInfo(0, this, "goal_info");
/*  239 */           _input_.readMessage(_v_);
/*  240 */           this.goal_info.put(Integer.valueOf(_k_), _v_);
/*  241 */           break;
/*      */         
/*      */ 
/*      */         case 16: 
/*  245 */           this.score_value = _input_.readInt32();
/*  246 */           break;
/*      */         
/*      */ 
/*      */         case 24: 
/*  250 */           int _v_ = 0;
/*  251 */           _v_ = _input_.readInt32();
/*  252 */           this.aleardy_awarded_score.add(Integer.valueOf(_v_));
/*  253 */           break;
/*      */         
/*      */ 
/*      */         case 32: 
/*  257 */           long _k_ = 0L;
/*  258 */           _k_ = _input_.readInt64();
/*  259 */           int readTag = _input_.readTag();
/*  260 */           if (34 != readTag)
/*      */           {
/*  262 */             throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*      */           }
/*  264 */           String _v_ = "";
/*  265 */           _v_ = _input_.readBytes().toString("UTF-16LE");
/*  266 */           this.activity_parameters_extra.put(Long.valueOf(_k_), _v_);
/*  267 */           break;
/*      */         
/*      */ 
/*      */         default: 
/*  271 */           if (!CodedInputStream.skipUnknownField(tag, _input_))
/*      */           {
/*  273 */             done = true;
/*      */           }
/*      */           break;
/*      */         }
/*      */         
/*      */       }
/*      */     }
/*      */     catch (InvalidProtocolBufferException e)
/*      */     {
/*  282 */       throw e.setUnfinishedMessage(this);
/*      */     }
/*      */     catch (java.io.IOException e)
/*      */     {
/*  286 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */     }
/*  288 */     return _input_;
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.ActivityAchievementInfo copy()
/*      */   {
/*  294 */     _xdb_verify_unsafe_();
/*  295 */     return new ActivityAchievementInfo(this);
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.ActivityAchievementInfo toData()
/*      */   {
/*  301 */     _xdb_verify_unsafe_();
/*  302 */     return new Data(this);
/*      */   }
/*      */   
/*      */   public xbean.ActivityAchievementInfo toBean()
/*      */   {
/*  307 */     _xdb_verify_unsafe_();
/*  308 */     return new ActivityAchievementInfo(this);
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.ActivityAchievementInfo toDataIf()
/*      */   {
/*  314 */     _xdb_verify_unsafe_();
/*  315 */     return new Data(this);
/*      */   }
/*      */   
/*      */   public xbean.ActivityAchievementInfo toBeanIf()
/*      */   {
/*  320 */     _xdb_verify_unsafe_();
/*  321 */     return this;
/*      */   }
/*      */   
/*      */ 
/*      */   public xdb.Bean toConst()
/*      */   {
/*  327 */     _xdb_verify_unsafe_();
/*  328 */     return new Const(null);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<Integer, xbean.AchievementInfo> getGoal_info()
/*      */   {
/*  335 */     _xdb_verify_unsafe_();
/*  336 */     return xdb.Logs.logMap(new xdb.LogKey(this, "goal_info"), this.goal_info);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<Integer, xbean.AchievementInfo> getGoal_infoAsData()
/*      */   {
/*  343 */     _xdb_verify_unsafe_();
/*      */     
/*  345 */     ActivityAchievementInfo _o_ = this;
/*  346 */     Map<Integer, xbean.AchievementInfo> goal_info = new HashMap();
/*  347 */     for (Map.Entry<Integer, xbean.AchievementInfo> _e_ : _o_.goal_info.entrySet())
/*  348 */       goal_info.put(_e_.getKey(), new AchievementInfo.Data((xbean.AchievementInfo)_e_.getValue()));
/*  349 */     return goal_info;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getScore_value()
/*      */   {
/*  356 */     _xdb_verify_unsafe_();
/*  357 */     return this.score_value;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Set<Integer> getAleardy_awarded_score()
/*      */   {
/*  364 */     _xdb_verify_unsafe_();
/*  365 */     return xdb.Logs.logSet(new xdb.LogKey(this, "aleardy_awarded_score"), this.aleardy_awarded_score);
/*      */   }
/*      */   
/*      */ 
/*      */   public Set<Integer> getAleardy_awarded_scoreAsData()
/*      */   {
/*  371 */     _xdb_verify_unsafe_();
/*      */     
/*  373 */     ActivityAchievementInfo _o_ = this;
/*  374 */     Set<Integer> aleardy_awarded_score = new SetX();
/*  375 */     aleardy_awarded_score.addAll(_o_.aleardy_awarded_score);
/*  376 */     return aleardy_awarded_score;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<Long, String> getActivity_parameters_extra()
/*      */   {
/*  383 */     _xdb_verify_unsafe_();
/*  384 */     return xdb.Logs.logMap(new xdb.LogKey(this, "activity_parameters_extra"), this.activity_parameters_extra);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<Long, String> getActivity_parameters_extraAsData()
/*      */   {
/*  391 */     _xdb_verify_unsafe_();
/*      */     
/*  393 */     ActivityAchievementInfo _o_ = this;
/*  394 */     Map<Long, String> activity_parameters_extra = new HashMap();
/*  395 */     for (Map.Entry<Long, String> _e_ : _o_.activity_parameters_extra.entrySet())
/*  396 */       activity_parameters_extra.put(_e_.getKey(), _e_.getValue());
/*  397 */     return activity_parameters_extra;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setScore_value(int _v_)
/*      */   {
/*  404 */     _xdb_verify_unsafe_();
/*  405 */     xdb.Logs.logIf(new xdb.LogKey(this, "score_value")
/*      */     {
/*      */       protected xdb.Log create()
/*      */       {
/*  409 */         new xdb.logs.LogInt(this, ActivityAchievementInfo.this.score_value)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  413 */             ActivityAchievementInfo.this.score_value = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  417 */     });
/*  418 */     this.score_value = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */   public final boolean equals(Object _o1_)
/*      */   {
/*  424 */     _xdb_verify_unsafe_();
/*  425 */     ActivityAchievementInfo _o_ = null;
/*  426 */     if ((_o1_ instanceof ActivityAchievementInfo)) { _o_ = (ActivityAchievementInfo)_o1_;
/*  427 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/*  428 */       return false;
/*  429 */     if (!this.goal_info.equals(_o_.goal_info)) return false;
/*  430 */     if (this.score_value != _o_.score_value) return false;
/*  431 */     if (!this.aleardy_awarded_score.equals(_o_.aleardy_awarded_score)) return false;
/*  432 */     if (!this.activity_parameters_extra.equals(_o_.activity_parameters_extra)) return false;
/*  433 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */   public final int hashCode()
/*      */   {
/*  439 */     _xdb_verify_unsafe_();
/*  440 */     int _h_ = 0;
/*  441 */     _h_ += this.goal_info.hashCode();
/*  442 */     _h_ += this.score_value;
/*  443 */     _h_ += this.aleardy_awarded_score.hashCode();
/*  444 */     _h_ += this.activity_parameters_extra.hashCode();
/*  445 */     return _h_;
/*      */   }
/*      */   
/*      */ 
/*      */   public String toString()
/*      */   {
/*  451 */     _xdb_verify_unsafe_();
/*  452 */     StringBuilder _sb_ = new StringBuilder();
/*  453 */     _sb_.append("(");
/*  454 */     _sb_.append(this.goal_info);
/*  455 */     _sb_.append(",");
/*  456 */     _sb_.append(this.score_value);
/*  457 */     _sb_.append(",");
/*  458 */     _sb_.append(this.aleardy_awarded_score);
/*  459 */     _sb_.append(",");
/*  460 */     _sb_.append(this.activity_parameters_extra);
/*  461 */     _sb_.append(")");
/*  462 */     return _sb_.toString();
/*      */   }
/*      */   
/*      */ 
/*      */   public xdb.logs.Listenable newListenable()
/*      */   {
/*  468 */     xdb.logs.ListenableBean lb = new xdb.logs.ListenableBean();
/*  469 */     lb.add(new xdb.logs.ListenableMap().setVarName("goal_info"));
/*  470 */     lb.add(new xdb.logs.ListenableChanged().setVarName("score_value"));
/*  471 */     lb.add(new xdb.logs.ListenableSet().setVarName("aleardy_awarded_score"));
/*  472 */     lb.add(new xdb.logs.ListenableMap().setVarName("activity_parameters_extra"));
/*  473 */     return lb;
/*      */   }
/*      */   
/*      */   private class Const implements xbean.ActivityAchievementInfo {
/*      */     private Const() {}
/*      */     
/*      */     ActivityAchievementInfo nThis() {
/*  480 */       return ActivityAchievementInfo.this;
/*      */     }
/*      */     
/*      */ 
/*      */     public void _reset_unsafe_()
/*      */     {
/*  486 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.ActivityAchievementInfo copy()
/*      */     {
/*  492 */       return ActivityAchievementInfo.this.copy();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.ActivityAchievementInfo toData()
/*      */     {
/*  498 */       return ActivityAchievementInfo.this.toData();
/*      */     }
/*      */     
/*      */     public xbean.ActivityAchievementInfo toBean()
/*      */     {
/*  503 */       return ActivityAchievementInfo.this.toBean();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.ActivityAchievementInfo toDataIf()
/*      */     {
/*  509 */       return ActivityAchievementInfo.this.toDataIf();
/*      */     }
/*      */     
/*      */     public xbean.ActivityAchievementInfo toBeanIf()
/*      */     {
/*  514 */       return ActivityAchievementInfo.this.toBeanIf();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, xbean.AchievementInfo> getGoal_info()
/*      */     {
/*  521 */       ActivityAchievementInfo.this._xdb_verify_unsafe_();
/*  522 */       return xdb.Consts.constMap(ActivityAchievementInfo.this.goal_info);
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, xbean.AchievementInfo> getGoal_infoAsData()
/*      */     {
/*  529 */       ActivityAchievementInfo.this._xdb_verify_unsafe_();
/*      */       
/*  531 */       ActivityAchievementInfo _o_ = ActivityAchievementInfo.this;
/*  532 */       Map<Integer, xbean.AchievementInfo> goal_info = new HashMap();
/*  533 */       for (Map.Entry<Integer, xbean.AchievementInfo> _e_ : _o_.goal_info.entrySet())
/*  534 */         goal_info.put(_e_.getKey(), new AchievementInfo.Data((xbean.AchievementInfo)_e_.getValue()));
/*  535 */       return goal_info;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getScore_value()
/*      */     {
/*  542 */       ActivityAchievementInfo.this._xdb_verify_unsafe_();
/*  543 */       return ActivityAchievementInfo.this.score_value;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Set<Integer> getAleardy_awarded_score()
/*      */     {
/*  550 */       ActivityAchievementInfo.this._xdb_verify_unsafe_();
/*  551 */       return xdb.Consts.constSet(ActivityAchievementInfo.this.aleardy_awarded_score);
/*      */     }
/*      */     
/*      */ 
/*      */     public Set<Integer> getAleardy_awarded_scoreAsData()
/*      */     {
/*  557 */       ActivityAchievementInfo.this._xdb_verify_unsafe_();
/*      */       
/*  559 */       ActivityAchievementInfo _o_ = ActivityAchievementInfo.this;
/*  560 */       Set<Integer> aleardy_awarded_score = new SetX();
/*  561 */       aleardy_awarded_score.addAll(_o_.aleardy_awarded_score);
/*  562 */       return aleardy_awarded_score;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Long, String> getActivity_parameters_extra()
/*      */     {
/*  569 */       ActivityAchievementInfo.this._xdb_verify_unsafe_();
/*  570 */       return xdb.Consts.constMap(ActivityAchievementInfo.this.activity_parameters_extra);
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Long, String> getActivity_parameters_extraAsData()
/*      */     {
/*  577 */       ActivityAchievementInfo.this._xdb_verify_unsafe_();
/*      */       
/*  579 */       ActivityAchievementInfo _o_ = ActivityAchievementInfo.this;
/*  580 */       Map<Long, String> activity_parameters_extra = new HashMap();
/*  581 */       for (Map.Entry<Long, String> _e_ : _o_.activity_parameters_extra.entrySet())
/*  582 */         activity_parameters_extra.put(_e_.getKey(), _e_.getValue());
/*  583 */       return activity_parameters_extra;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setScore_value(int _v_)
/*      */     {
/*  590 */       ActivityAchievementInfo.this._xdb_verify_unsafe_();
/*  591 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xdb.Bean toConst()
/*      */     {
/*  597 */       ActivityAchievementInfo.this._xdb_verify_unsafe_();
/*  598 */       return this;
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean isConst()
/*      */     {
/*  604 */       ActivityAchievementInfo.this._xdb_verify_unsafe_();
/*  605 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean isData()
/*      */     {
/*  611 */       return ActivityAchievementInfo.this.isData();
/*      */     }
/*      */     
/*      */ 
/*      */     public OctetsStream marshal(OctetsStream _os_)
/*      */     {
/*  617 */       return ActivityAchievementInfo.this.marshal(_os_);
/*      */     }
/*      */     
/*      */     public OctetsStream unmarshal(OctetsStream _os_)
/*      */       throws com.goldhuman.Common.Marshal.MarshalException
/*      */     {
/*  623 */       ActivityAchievementInfo.this._xdb_verify_unsafe_();
/*  624 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public int getSerializedSize()
/*      */     {
/*  630 */       return ActivityAchievementInfo.this.getSerializedSize();
/*      */     }
/*      */     
/*      */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*  636 */       return ActivityAchievementInfo.this.marshal(_output_);
/*      */     }
/*      */     
/*      */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*  642 */       ActivityAchievementInfo.this._xdb_verify_unsafe_();
/*  643 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xdb.Bean xdbParent()
/*      */     {
/*  649 */       return ActivityAchievementInfo.this.xdbParent();
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean xdbManaged()
/*      */     {
/*  655 */       return ActivityAchievementInfo.this.xdbManaged();
/*      */     }
/*      */     
/*      */ 
/*      */     public String xdbVarname()
/*      */     {
/*  661 */       return ActivityAchievementInfo.this.xdbVarname();
/*      */     }
/*      */     
/*      */ 
/*      */     public Long xdbObjId()
/*      */     {
/*  667 */       return ActivityAchievementInfo.this.xdbObjId();
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean equals(Object obj)
/*      */     {
/*  673 */       return ActivityAchievementInfo.this.equals(obj);
/*      */     }
/*      */     
/*      */ 
/*      */     public int hashCode()
/*      */     {
/*  679 */       return ActivityAchievementInfo.this.hashCode();
/*      */     }
/*      */     
/*      */ 
/*      */     public String toString()
/*      */     {
/*  685 */       return ActivityAchievementInfo.this.toString();
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */   public static final class Data
/*      */     implements xbean.ActivityAchievementInfo
/*      */   {
/*      */     private HashMap<Integer, xbean.AchievementInfo> goal_info;
/*      */     
/*      */     private int score_value;
/*      */     
/*      */     private HashSet<Integer> aleardy_awarded_score;
/*      */     
/*      */     private HashMap<Long, String> activity_parameters_extra;
/*      */     
/*      */     public void _reset_unsafe_()
/*      */     {
/*  703 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Data()
/*      */     {
/*  708 */       this.goal_info = new HashMap();
/*  709 */       this.aleardy_awarded_score = new HashSet();
/*  710 */       this.activity_parameters_extra = new HashMap();
/*      */     }
/*      */     
/*      */     Data(xbean.ActivityAchievementInfo _o1_)
/*      */     {
/*  715 */       if ((_o1_ instanceof ActivityAchievementInfo)) { assign((ActivityAchievementInfo)_o1_);
/*  716 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  717 */       } else if ((_o1_ instanceof ActivityAchievementInfo.Const)) assign(((ActivityAchievementInfo.Const)_o1_).nThis()); else {
/*  718 */         throw new UnsupportedOperationException();
/*      */       }
/*      */     }
/*      */     
/*      */     private void assign(ActivityAchievementInfo _o_) {
/*  723 */       this.goal_info = new HashMap();
/*  724 */       for (Map.Entry<Integer, xbean.AchievementInfo> _e_ : _o_.goal_info.entrySet())
/*  725 */         this.goal_info.put(_e_.getKey(), new AchievementInfo.Data((xbean.AchievementInfo)_e_.getValue()));
/*  726 */       this.score_value = _o_.score_value;
/*  727 */       this.aleardy_awarded_score = new HashSet();
/*  728 */       this.aleardy_awarded_score.addAll(_o_.aleardy_awarded_score);
/*  729 */       this.activity_parameters_extra = new HashMap();
/*  730 */       for (Map.Entry<Long, String> _e_ : _o_.activity_parameters_extra.entrySet()) {
/*  731 */         this.activity_parameters_extra.put(_e_.getKey(), _e_.getValue());
/*      */       }
/*      */     }
/*      */     
/*      */     private void assign(Data _o_) {
/*  736 */       this.goal_info = new HashMap();
/*  737 */       for (Map.Entry<Integer, xbean.AchievementInfo> _e_ : _o_.goal_info.entrySet())
/*  738 */         this.goal_info.put(_e_.getKey(), new AchievementInfo.Data((xbean.AchievementInfo)_e_.getValue()));
/*  739 */       this.score_value = _o_.score_value;
/*  740 */       this.aleardy_awarded_score = new HashSet();
/*  741 */       this.aleardy_awarded_score.addAll(_o_.aleardy_awarded_score);
/*  742 */       this.activity_parameters_extra = new HashMap();
/*  743 */       for (Map.Entry<Long, String> _e_ : _o_.activity_parameters_extra.entrySet()) {
/*  744 */         this.activity_parameters_extra.put(_e_.getKey(), _e_.getValue());
/*      */       }
/*      */     }
/*      */     
/*      */     public final OctetsStream marshal(OctetsStream _os_)
/*      */     {
/*  750 */       _os_.compact_uint32(this.goal_info.size());
/*  751 */       for (Map.Entry<Integer, xbean.AchievementInfo> _e_ : this.goal_info.entrySet())
/*      */       {
/*  753 */         _os_.marshal(((Integer)_e_.getKey()).intValue());
/*  754 */         ((xbean.AchievementInfo)_e_.getValue()).marshal(_os_);
/*      */       }
/*  756 */       _os_.marshal(this.score_value);
/*  757 */       _os_.compact_uint32(this.aleardy_awarded_score.size());
/*  758 */       for (Integer _v_ : this.aleardy_awarded_score)
/*      */       {
/*  760 */         _os_.marshal(_v_.intValue());
/*      */       }
/*  762 */       _os_.compact_uint32(this.activity_parameters_extra.size());
/*  763 */       for (Map.Entry<Long, String> _e_ : this.activity_parameters_extra.entrySet())
/*      */       {
/*  765 */         _os_.marshal(((Long)_e_.getKey()).longValue());
/*  766 */         _os_.marshal((String)_e_.getValue(), "UTF-16LE");
/*      */       }
/*  768 */       return _os_;
/*      */     }
/*      */     
/*      */ 
/*      */     public final OctetsStream unmarshal(OctetsStream _os_)
/*      */       throws com.goldhuman.Common.Marshal.MarshalException
/*      */     {
/*  775 */       int size = _os_.uncompact_uint32();
/*  776 */       if (size >= 12)
/*      */       {
/*  778 */         this.goal_info = new HashMap(size * 2);
/*      */       }
/*  780 */       for (; size > 0; size--)
/*      */       {
/*  782 */         int _k_ = 0;
/*  783 */         _k_ = _os_.unmarshal_int();
/*  784 */         xbean.AchievementInfo _v_ = xbean.Pod.newAchievementInfoData();
/*  785 */         _v_.unmarshal(_os_);
/*  786 */         this.goal_info.put(Integer.valueOf(_k_), _v_);
/*      */       }
/*      */       
/*  789 */       this.score_value = _os_.unmarshal_int();
/*  790 */       for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*      */       {
/*  792 */         int _v_ = 0;
/*  793 */         _v_ = _os_.unmarshal_int();
/*  794 */         this.aleardy_awarded_score.add(Integer.valueOf(_v_));
/*      */       }
/*      */       
/*  797 */       int size = _os_.uncompact_uint32();
/*  798 */       if (size >= 12)
/*      */       {
/*  800 */         this.activity_parameters_extra = new HashMap(size * 2);
/*      */       }
/*  802 */       for (; size > 0; size--)
/*      */       {
/*  804 */         long _k_ = 0L;
/*  805 */         _k_ = _os_.unmarshal_long();
/*  806 */         String _v_ = "";
/*  807 */         _v_ = _os_.unmarshal_String("UTF-16LE");
/*  808 */         this.activity_parameters_extra.put(Long.valueOf(_k_), _v_);
/*      */       }
/*      */       
/*  811 */       return _os_;
/*      */     }
/*      */     
/*      */ 
/*      */     public final int getSerializedSize()
/*      */     {
/*  817 */       int _size_ = 0;
/*  818 */       for (Map.Entry<Integer, xbean.AchievementInfo> _e_ : this.goal_info.entrySet())
/*      */       {
/*  820 */         _size_ += CodedOutputStream.computeInt32Size(1, ((Integer)_e_.getKey()).intValue());
/*  821 */         _size_ += CodedOutputStream.computeMessageSize(1, (ppbio.Message)_e_.getValue());
/*      */       }
/*  823 */       _size_ += CodedOutputStream.computeInt32Size(2, this.score_value);
/*  824 */       for (Integer _v_ : this.aleardy_awarded_score)
/*      */       {
/*  826 */         _size_ += CodedOutputStream.computeInt32Size(3, _v_.intValue());
/*      */       }
/*  828 */       for (Map.Entry<Long, String> _e_ : this.activity_parameters_extra.entrySet())
/*      */       {
/*  830 */         _size_ += CodedOutputStream.computeInt64Size(4, ((Long)_e_.getKey()).longValue());
/*      */         try
/*      */         {
/*  833 */           _size_ += CodedOutputStream.computeBytesSize(4, ppbio.ByteString.copyFrom((String)_e_.getValue(), "UTF-16LE"));
/*      */         }
/*      */         catch (java.io.UnsupportedEncodingException e)
/*      */         {
/*  837 */           throw new RuntimeException("UTF-16LE not supported?", e);
/*      */         }
/*      */       }
/*  840 */       return _size_;
/*      */     }
/*      */     
/*      */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*      */       try
/*      */       {
/*  848 */         for (Map.Entry<Integer, xbean.AchievementInfo> _e_ : this.goal_info.entrySet())
/*      */         {
/*  850 */           _output_.writeInt32(1, ((Integer)_e_.getKey()).intValue());
/*  851 */           _output_.writeMessage(1, (ppbio.Message)_e_.getValue());
/*      */         }
/*  853 */         _output_.writeInt32(2, this.score_value);
/*  854 */         for (Integer _v_ : this.aleardy_awarded_score)
/*      */         {
/*  856 */           _output_.writeInt32(3, _v_.intValue());
/*      */         }
/*  858 */         for (Map.Entry<Long, String> _e_ : this.activity_parameters_extra.entrySet())
/*      */         {
/*  860 */           _output_.writeInt64(4, ((Long)_e_.getKey()).longValue());
/*  861 */           _output_.writeBytes(4, ppbio.ByteString.copyFrom((String)_e_.getValue(), "UTF-16LE"));
/*      */         }
/*      */       }
/*      */       catch (java.io.IOException e)
/*      */       {
/*  866 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */       }
/*  868 */       return _output_;
/*      */     }
/*      */     
/*      */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*      */       try
/*      */       {
/*  876 */         boolean done = false;
/*  877 */         while (!done)
/*      */         {
/*  879 */           int tag = _input_.readTag();
/*  880 */           switch (tag)
/*      */           {
/*      */ 
/*      */           case 0: 
/*  884 */             done = true;
/*  885 */             break;
/*      */           
/*      */ 
/*      */           case 8: 
/*  889 */             int _k_ = 0;
/*  890 */             _k_ = _input_.readInt32();
/*  891 */             int readTag = _input_.readTag();
/*  892 */             if (10 != readTag)
/*      */             {
/*  894 */               throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*      */             }
/*  896 */             xbean.AchievementInfo _v_ = xbean.Pod.newAchievementInfoData();
/*  897 */             _input_.readMessage(_v_);
/*  898 */             this.goal_info.put(Integer.valueOf(_k_), _v_);
/*  899 */             break;
/*      */           
/*      */ 
/*      */           case 16: 
/*  903 */             this.score_value = _input_.readInt32();
/*  904 */             break;
/*      */           
/*      */ 
/*      */           case 24: 
/*  908 */             int _v_ = 0;
/*  909 */             _v_ = _input_.readInt32();
/*  910 */             this.aleardy_awarded_score.add(Integer.valueOf(_v_));
/*  911 */             break;
/*      */           
/*      */ 
/*      */           case 32: 
/*  915 */             long _k_ = 0L;
/*  916 */             _k_ = _input_.readInt64();
/*  917 */             int readTag = _input_.readTag();
/*  918 */             if (34 != readTag)
/*      */             {
/*  920 */               throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*      */             }
/*  922 */             String _v_ = "";
/*  923 */             _v_ = _input_.readBytes().toString("UTF-16LE");
/*  924 */             this.activity_parameters_extra.put(Long.valueOf(_k_), _v_);
/*  925 */             break;
/*      */           
/*      */ 
/*      */           default: 
/*  929 */             if (!CodedInputStream.skipUnknownField(tag, _input_))
/*      */             {
/*  931 */               done = true;
/*      */             }
/*      */             break;
/*      */           }
/*      */           
/*      */         }
/*      */       }
/*      */       catch (InvalidProtocolBufferException e)
/*      */       {
/*  940 */         throw e.setUnfinishedMessage(this);
/*      */       }
/*      */       catch (java.io.IOException e)
/*      */       {
/*  944 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */       }
/*  946 */       return _input_;
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.ActivityAchievementInfo copy()
/*      */     {
/*  952 */       return new Data(this);
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.ActivityAchievementInfo toData()
/*      */     {
/*  958 */       return new Data(this);
/*      */     }
/*      */     
/*      */     public xbean.ActivityAchievementInfo toBean()
/*      */     {
/*  963 */       return new ActivityAchievementInfo(this, null, null);
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.ActivityAchievementInfo toDataIf()
/*      */     {
/*  969 */       return this;
/*      */     }
/*      */     
/*      */     public xbean.ActivityAchievementInfo toBeanIf()
/*      */     {
/*  974 */       return new ActivityAchievementInfo(this, null, null);
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean xdbManaged()
/*      */     {
/*  980 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public xdb.Bean xdbParent() {
/*  984 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public String xdbVarname() {
/*  988 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Long xdbObjId() {
/*  992 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public xdb.Bean toConst() {
/*  996 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public boolean isConst() {
/* 1000 */       return false;
/*      */     }
/*      */     
/*      */     public boolean isData() {
/* 1004 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, xbean.AchievementInfo> getGoal_info()
/*      */     {
/* 1011 */       return this.goal_info;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, xbean.AchievementInfo> getGoal_infoAsData()
/*      */     {
/* 1018 */       return this.goal_info;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getScore_value()
/*      */     {
/* 1025 */       return this.score_value;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Set<Integer> getAleardy_awarded_score()
/*      */     {
/* 1032 */       return this.aleardy_awarded_score;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Set<Integer> getAleardy_awarded_scoreAsData()
/*      */     {
/* 1039 */       return this.aleardy_awarded_score;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Long, String> getActivity_parameters_extra()
/*      */     {
/* 1046 */       return this.activity_parameters_extra;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Long, String> getActivity_parameters_extraAsData()
/*      */     {
/* 1053 */       return this.activity_parameters_extra;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setScore_value(int _v_)
/*      */     {
/* 1060 */       this.score_value = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */     public final boolean equals(Object _o1_)
/*      */     {
/* 1066 */       if (!(_o1_ instanceof Data)) return false;
/* 1067 */       Data _o_ = (Data)_o1_;
/* 1068 */       if (!this.goal_info.equals(_o_.goal_info)) return false;
/* 1069 */       if (this.score_value != _o_.score_value) return false;
/* 1070 */       if (!this.aleardy_awarded_score.equals(_o_.aleardy_awarded_score)) return false;
/* 1071 */       if (!this.activity_parameters_extra.equals(_o_.activity_parameters_extra)) return false;
/* 1072 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */     public final int hashCode()
/*      */     {
/* 1078 */       int _h_ = 0;
/* 1079 */       _h_ += this.goal_info.hashCode();
/* 1080 */       _h_ += this.score_value;
/* 1081 */       _h_ += this.aleardy_awarded_score.hashCode();
/* 1082 */       _h_ += this.activity_parameters_extra.hashCode();
/* 1083 */       return _h_;
/*      */     }
/*      */     
/*      */ 
/*      */     public String toString()
/*      */     {
/* 1089 */       StringBuilder _sb_ = new StringBuilder();
/* 1090 */       _sb_.append("(");
/* 1091 */       _sb_.append(this.goal_info);
/* 1092 */       _sb_.append(",");
/* 1093 */       _sb_.append(this.score_value);
/* 1094 */       _sb_.append(",");
/* 1095 */       _sb_.append(this.aleardy_awarded_score);
/* 1096 */       _sb_.append(",");
/* 1097 */       _sb_.append(this.activity_parameters_extra);
/* 1098 */       _sb_.append(")");
/* 1099 */       return _sb_.toString();
/*      */     }
/*      */   }
/*      */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\ActivityAchievementInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */