/*      */ package xbean.__;
/*      */ 
/*      */ import com.goldhuman.Common.Marshal.OctetsStream;
/*      */ import java.util.ArrayList;
/*      */ import java.util.HashMap;
/*      */ import java.util.List;
/*      */ import java.util.Map;
/*      */ import java.util.Map.Entry;
/*      */ import ppbio.CodedInputStream;
/*      */ import ppbio.CodedOutputStream;
/*      */ import ppbio.InvalidProtocolBufferException;
/*      */ import xdb.LogKey;
/*      */ import xdb.XBean;
/*      */ 
/*      */ public final class AchievementInfo extends XBean implements xbean.AchievementInfo
/*      */ {
/*      */   private int goal_state;
/*      */   private ArrayList<Integer> goal_parameters;
/*      */   private HashMap<Long, String> goal_parameters_extra;
/*      */   private long goal_achieve_time;
/*      */   
/*      */   public void _reset_unsafe_()
/*      */   {
/*   24 */     this.goal_state = 0;
/*   25 */     this.goal_parameters.clear();
/*   26 */     this.goal_parameters_extra.clear();
/*   27 */     this.goal_achieve_time = 0L;
/*      */   }
/*      */   
/*      */   AchievementInfo(int __, XBean _xp_, String _vn_)
/*      */   {
/*   32 */     super(_xp_, _vn_);
/*   33 */     this.goal_parameters = new ArrayList();
/*   34 */     this.goal_parameters_extra = new HashMap();
/*      */   }
/*      */   
/*      */   public AchievementInfo()
/*      */   {
/*   39 */     this(0, null, null);
/*      */   }
/*      */   
/*      */   public AchievementInfo(AchievementInfo _o_)
/*      */   {
/*   44 */     this(_o_, null, null);
/*      */   }
/*      */   
/*      */   AchievementInfo(xbean.AchievementInfo _o1_, XBean _xp_, String _vn_)
/*      */   {
/*   49 */     super(_xp_, _vn_);
/*   50 */     if ((_o1_ instanceof AchievementInfo)) { assign((AchievementInfo)_o1_);
/*   51 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*   52 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*   53 */       throw new UnsupportedOperationException();
/*      */     }
/*      */   }
/*      */   
/*      */   private void assign(AchievementInfo _o_) {
/*   58 */     _o_._xdb_verify_unsafe_();
/*   59 */     this.goal_state = _o_.goal_state;
/*   60 */     this.goal_parameters = new ArrayList();
/*   61 */     this.goal_parameters.addAll(_o_.goal_parameters);
/*   62 */     this.goal_parameters_extra = new HashMap();
/*   63 */     for (Map.Entry<Long, String> _e_ : _o_.goal_parameters_extra.entrySet())
/*   64 */       this.goal_parameters_extra.put(_e_.getKey(), _e_.getValue());
/*   65 */     this.goal_achieve_time = _o_.goal_achieve_time;
/*      */   }
/*      */   
/*      */   private void assign(Data _o_)
/*      */   {
/*   70 */     this.goal_state = _o_.goal_state;
/*   71 */     this.goal_parameters = new ArrayList();
/*   72 */     this.goal_parameters.addAll(_o_.goal_parameters);
/*   73 */     this.goal_parameters_extra = new HashMap();
/*   74 */     for (Map.Entry<Long, String> _e_ : _o_.goal_parameters_extra.entrySet())
/*   75 */       this.goal_parameters_extra.put(_e_.getKey(), _e_.getValue());
/*   76 */     this.goal_achieve_time = _o_.goal_achieve_time;
/*      */   }
/*      */   
/*      */ 
/*      */   public final OctetsStream marshal(OctetsStream _os_)
/*      */   {
/*   82 */     _xdb_verify_unsafe_();
/*   83 */     _os_.marshal(this.goal_state);
/*   84 */     _os_.compact_uint32(this.goal_parameters.size());
/*   85 */     for (Integer _v_ : this.goal_parameters)
/*      */     {
/*   87 */       _os_.marshal(_v_.intValue());
/*      */     }
/*   89 */     _os_.compact_uint32(this.goal_parameters_extra.size());
/*   90 */     for (Map.Entry<Long, String> _e_ : this.goal_parameters_extra.entrySet())
/*      */     {
/*   92 */       _os_.marshal(((Long)_e_.getKey()).longValue());
/*   93 */       _os_.marshal((String)_e_.getValue(), "UTF-16LE");
/*      */     }
/*   95 */     _os_.marshal(this.goal_achieve_time);
/*   96 */     return _os_;
/*      */   }
/*      */   
/*      */   public final OctetsStream unmarshal(OctetsStream _os_)
/*      */     throws com.goldhuman.Common.Marshal.MarshalException
/*      */   {
/*  102 */     _xdb_verify_unsafe_();
/*  103 */     this.goal_state = _os_.unmarshal_int();
/*  104 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*      */     {
/*  106 */       int _v_ = 0;
/*  107 */       _v_ = _os_.unmarshal_int();
/*  108 */       this.goal_parameters.add(Integer.valueOf(_v_));
/*      */     }
/*      */     
/*  111 */     int size = _os_.uncompact_uint32();
/*  112 */     if (size >= 12)
/*      */     {
/*  114 */       this.goal_parameters_extra = new HashMap(size * 2);
/*      */     }
/*  116 */     for (; size > 0; size--)
/*      */     {
/*  118 */       long _k_ = 0L;
/*  119 */       _k_ = _os_.unmarshal_long();
/*  120 */       String _v_ = "";
/*  121 */       _v_ = _os_.unmarshal_String("UTF-16LE");
/*  122 */       this.goal_parameters_extra.put(Long.valueOf(_k_), _v_);
/*      */     }
/*      */     
/*  125 */     this.goal_achieve_time = _os_.unmarshal_long();
/*  126 */     return _os_;
/*      */   }
/*      */   
/*      */ 
/*      */   public int getSerializedSize()
/*      */   {
/*  132 */     _xdb_verify_unsafe_();
/*  133 */     int _size_ = 0;
/*  134 */     _size_ += CodedOutputStream.computeInt32Size(1, this.goal_state);
/*  135 */     for (Integer _v_ : this.goal_parameters)
/*      */     {
/*  137 */       _size_ += CodedOutputStream.computeInt32Size(2, _v_.intValue());
/*      */     }
/*  139 */     for (Map.Entry<Long, String> _e_ : this.goal_parameters_extra.entrySet())
/*      */     {
/*  141 */       _size_ += CodedOutputStream.computeInt64Size(3, ((Long)_e_.getKey()).longValue());
/*      */       try
/*      */       {
/*  144 */         _size_ += CodedOutputStream.computeBytesSize(3, ppbio.ByteString.copyFrom((String)_e_.getValue(), "UTF-16LE"));
/*      */       }
/*      */       catch (java.io.UnsupportedEncodingException e)
/*      */       {
/*  148 */         throw new RuntimeException("UTF-16LE not supported?", e);
/*      */       }
/*      */     }
/*  151 */     _size_ += CodedOutputStream.computeInt64Size(4, this.goal_achieve_time);
/*  152 */     return _size_;
/*      */   }
/*      */   
/*      */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */     throws InvalidProtocolBufferException
/*      */   {
/*  158 */     _xdb_verify_unsafe_();
/*      */     try
/*      */     {
/*  161 */       _output_.writeInt32(1, this.goal_state);
/*  162 */       for (Integer _v_ : this.goal_parameters)
/*      */       {
/*  164 */         _output_.writeInt32(2, _v_.intValue());
/*      */       }
/*  166 */       for (Map.Entry<Long, String> _e_ : this.goal_parameters_extra.entrySet())
/*      */       {
/*  168 */         _output_.writeInt64(3, ((Long)_e_.getKey()).longValue());
/*  169 */         _output_.writeBytes(3, ppbio.ByteString.copyFrom((String)_e_.getValue(), "UTF-16LE"));
/*      */       }
/*  171 */       _output_.writeInt64(4, this.goal_achieve_time);
/*      */     }
/*      */     catch (java.io.IOException e)
/*      */     {
/*  175 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */     }
/*  177 */     return _output_;
/*      */   }
/*      */   
/*      */   public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */     throws InvalidProtocolBufferException
/*      */   {
/*  183 */     _xdb_verify_unsafe_();
/*      */     try
/*      */     {
/*  186 */       boolean done = false;
/*  187 */       while (!done)
/*      */       {
/*  189 */         int tag = _input_.readTag();
/*  190 */         switch (tag)
/*      */         {
/*      */ 
/*      */         case 0: 
/*  194 */           done = true;
/*  195 */           break;
/*      */         
/*      */ 
/*      */         case 8: 
/*  199 */           this.goal_state = _input_.readInt32();
/*  200 */           break;
/*      */         
/*      */ 
/*      */         case 16: 
/*  204 */           int _v_ = 0;
/*  205 */           _v_ = _input_.readInt32();
/*  206 */           this.goal_parameters.add(Integer.valueOf(_v_));
/*  207 */           break;
/*      */         
/*      */ 
/*      */         case 24: 
/*  211 */           long _k_ = 0L;
/*  212 */           _k_ = _input_.readInt64();
/*  213 */           int readTag = _input_.readTag();
/*  214 */           if (26 != readTag)
/*      */           {
/*  216 */             throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*      */           }
/*  218 */           String _v_ = "";
/*  219 */           _v_ = _input_.readBytes().toString("UTF-16LE");
/*  220 */           this.goal_parameters_extra.put(Long.valueOf(_k_), _v_);
/*  221 */           break;
/*      */         
/*      */ 
/*      */         case 32: 
/*  225 */           this.goal_achieve_time = _input_.readInt64();
/*  226 */           break;
/*      */         
/*      */ 
/*      */         default: 
/*  230 */           if (!CodedInputStream.skipUnknownField(tag, _input_))
/*      */           {
/*  232 */             done = true;
/*      */           }
/*      */           break;
/*      */         }
/*      */         
/*      */       }
/*      */     }
/*      */     catch (InvalidProtocolBufferException e)
/*      */     {
/*  241 */       throw e.setUnfinishedMessage(this);
/*      */     }
/*      */     catch (java.io.IOException e)
/*      */     {
/*  245 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */     }
/*  247 */     return _input_;
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.AchievementInfo copy()
/*      */   {
/*  253 */     _xdb_verify_unsafe_();
/*  254 */     return new AchievementInfo(this);
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.AchievementInfo toData()
/*      */   {
/*  260 */     _xdb_verify_unsafe_();
/*  261 */     return new Data(this);
/*      */   }
/*      */   
/*      */   public xbean.AchievementInfo toBean()
/*      */   {
/*  266 */     _xdb_verify_unsafe_();
/*  267 */     return new AchievementInfo(this);
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.AchievementInfo toDataIf()
/*      */   {
/*  273 */     _xdb_verify_unsafe_();
/*  274 */     return new Data(this);
/*      */   }
/*      */   
/*      */   public xbean.AchievementInfo toBeanIf()
/*      */   {
/*  279 */     _xdb_verify_unsafe_();
/*  280 */     return this;
/*      */   }
/*      */   
/*      */ 
/*      */   public xdb.Bean toConst()
/*      */   {
/*  286 */     _xdb_verify_unsafe_();
/*  287 */     return new Const(null);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getGoal_state()
/*      */   {
/*  294 */     _xdb_verify_unsafe_();
/*  295 */     return this.goal_state;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public List<Integer> getGoal_parameters()
/*      */   {
/*  302 */     _xdb_verify_unsafe_();
/*  303 */     return xdb.Logs.logList(new LogKey(this, "goal_parameters"), this.goal_parameters);
/*      */   }
/*      */   
/*      */ 
/*      */   public List<Integer> getGoal_parametersAsData()
/*      */   {
/*  309 */     _xdb_verify_unsafe_();
/*      */     
/*  311 */     AchievementInfo _o_ = this;
/*  312 */     List<Integer> goal_parameters = new ArrayList();
/*  313 */     goal_parameters.addAll(_o_.goal_parameters);
/*  314 */     return goal_parameters;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<Long, String> getGoal_parameters_extra()
/*      */   {
/*  321 */     _xdb_verify_unsafe_();
/*  322 */     return xdb.Logs.logMap(new LogKey(this, "goal_parameters_extra"), this.goal_parameters_extra);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<Long, String> getGoal_parameters_extraAsData()
/*      */   {
/*  329 */     _xdb_verify_unsafe_();
/*      */     
/*  331 */     AchievementInfo _o_ = this;
/*  332 */     Map<Long, String> goal_parameters_extra = new HashMap();
/*  333 */     for (Map.Entry<Long, String> _e_ : _o_.goal_parameters_extra.entrySet())
/*  334 */       goal_parameters_extra.put(_e_.getKey(), _e_.getValue());
/*  335 */     return goal_parameters_extra;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public long getGoal_achieve_time()
/*      */   {
/*  342 */     _xdb_verify_unsafe_();
/*  343 */     return this.goal_achieve_time;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setGoal_state(int _v_)
/*      */   {
/*  350 */     _xdb_verify_unsafe_();
/*  351 */     xdb.Logs.logIf(new LogKey(this, "goal_state")
/*      */     {
/*      */       protected xdb.Log create()
/*      */       {
/*  355 */         new xdb.logs.LogInt(this, AchievementInfo.this.goal_state)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  359 */             AchievementInfo.this.goal_state = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  363 */     });
/*  364 */     this.goal_state = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setGoal_achieve_time(long _v_)
/*      */   {
/*  371 */     _xdb_verify_unsafe_();
/*  372 */     xdb.Logs.logIf(new LogKey(this, "goal_achieve_time")
/*      */     {
/*      */       protected xdb.Log create()
/*      */       {
/*  376 */         new xdb.logs.LogLong(this, AchievementInfo.this.goal_achieve_time)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  380 */             AchievementInfo.this.goal_achieve_time = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  384 */     });
/*  385 */     this.goal_achieve_time = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */   public final boolean equals(Object _o1_)
/*      */   {
/*  391 */     _xdb_verify_unsafe_();
/*  392 */     AchievementInfo _o_ = null;
/*  393 */     if ((_o1_ instanceof AchievementInfo)) { _o_ = (AchievementInfo)_o1_;
/*  394 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/*  395 */       return false;
/*  396 */     if (this.goal_state != _o_.goal_state) return false;
/*  397 */     if (!this.goal_parameters.equals(_o_.goal_parameters)) return false;
/*  398 */     if (!this.goal_parameters_extra.equals(_o_.goal_parameters_extra)) return false;
/*  399 */     if (this.goal_achieve_time != _o_.goal_achieve_time) return false;
/*  400 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */   public final int hashCode()
/*      */   {
/*  406 */     _xdb_verify_unsafe_();
/*  407 */     int _h_ = 0;
/*  408 */     _h_ += this.goal_state;
/*  409 */     _h_ += this.goal_parameters.hashCode();
/*  410 */     _h_ += this.goal_parameters_extra.hashCode();
/*  411 */     _h_ = (int)(_h_ + this.goal_achieve_time);
/*  412 */     return _h_;
/*      */   }
/*      */   
/*      */ 
/*      */   public String toString()
/*      */   {
/*  418 */     _xdb_verify_unsafe_();
/*  419 */     StringBuilder _sb_ = new StringBuilder();
/*  420 */     _sb_.append("(");
/*  421 */     _sb_.append(this.goal_state);
/*  422 */     _sb_.append(",");
/*  423 */     _sb_.append(this.goal_parameters);
/*  424 */     _sb_.append(",");
/*  425 */     _sb_.append(this.goal_parameters_extra);
/*  426 */     _sb_.append(",");
/*  427 */     _sb_.append(this.goal_achieve_time);
/*  428 */     _sb_.append(")");
/*  429 */     return _sb_.toString();
/*      */   }
/*      */   
/*      */ 
/*      */   public xdb.logs.Listenable newListenable()
/*      */   {
/*  435 */     xdb.logs.ListenableBean lb = new xdb.logs.ListenableBean();
/*  436 */     lb.add(new xdb.logs.ListenableChanged().setVarName("goal_state"));
/*  437 */     lb.add(new xdb.logs.ListenableChanged().setVarName("goal_parameters"));
/*  438 */     lb.add(new xdb.logs.ListenableMap().setVarName("goal_parameters_extra"));
/*  439 */     lb.add(new xdb.logs.ListenableChanged().setVarName("goal_achieve_time"));
/*  440 */     return lb;
/*      */   }
/*      */   
/*      */   private class Const implements xbean.AchievementInfo {
/*      */     private Const() {}
/*      */     
/*      */     AchievementInfo nThis() {
/*  447 */       return AchievementInfo.this;
/*      */     }
/*      */     
/*      */ 
/*      */     public void _reset_unsafe_()
/*      */     {
/*  453 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.AchievementInfo copy()
/*      */     {
/*  459 */       return AchievementInfo.this.copy();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.AchievementInfo toData()
/*      */     {
/*  465 */       return AchievementInfo.this.toData();
/*      */     }
/*      */     
/*      */     public xbean.AchievementInfo toBean()
/*      */     {
/*  470 */       return AchievementInfo.this.toBean();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.AchievementInfo toDataIf()
/*      */     {
/*  476 */       return AchievementInfo.this.toDataIf();
/*      */     }
/*      */     
/*      */     public xbean.AchievementInfo toBeanIf()
/*      */     {
/*  481 */       return AchievementInfo.this.toBeanIf();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getGoal_state()
/*      */     {
/*  488 */       AchievementInfo.this._xdb_verify_unsafe_();
/*  489 */       return AchievementInfo.this.goal_state;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public List<Integer> getGoal_parameters()
/*      */     {
/*  496 */       AchievementInfo.this._xdb_verify_unsafe_();
/*  497 */       return xdb.Consts.constList(AchievementInfo.this.goal_parameters);
/*      */     }
/*      */     
/*      */ 
/*      */     public List<Integer> getGoal_parametersAsData()
/*      */     {
/*  503 */       AchievementInfo.this._xdb_verify_unsafe_();
/*      */       
/*  505 */       AchievementInfo _o_ = AchievementInfo.this;
/*  506 */       List<Integer> goal_parameters = new ArrayList();
/*  507 */       goal_parameters.addAll(_o_.goal_parameters);
/*  508 */       return goal_parameters;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Long, String> getGoal_parameters_extra()
/*      */     {
/*  515 */       AchievementInfo.this._xdb_verify_unsafe_();
/*  516 */       return xdb.Consts.constMap(AchievementInfo.this.goal_parameters_extra);
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Long, String> getGoal_parameters_extraAsData()
/*      */     {
/*  523 */       AchievementInfo.this._xdb_verify_unsafe_();
/*      */       
/*  525 */       AchievementInfo _o_ = AchievementInfo.this;
/*  526 */       Map<Long, String> goal_parameters_extra = new HashMap();
/*  527 */       for (Map.Entry<Long, String> _e_ : _o_.goal_parameters_extra.entrySet())
/*  528 */         goal_parameters_extra.put(_e_.getKey(), _e_.getValue());
/*  529 */       return goal_parameters_extra;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getGoal_achieve_time()
/*      */     {
/*  536 */       AchievementInfo.this._xdb_verify_unsafe_();
/*  537 */       return AchievementInfo.this.goal_achieve_time;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setGoal_state(int _v_)
/*      */     {
/*  544 */       AchievementInfo.this._xdb_verify_unsafe_();
/*  545 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setGoal_achieve_time(long _v_)
/*      */     {
/*  552 */       AchievementInfo.this._xdb_verify_unsafe_();
/*  553 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xdb.Bean toConst()
/*      */     {
/*  559 */       AchievementInfo.this._xdb_verify_unsafe_();
/*  560 */       return this;
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean isConst()
/*      */     {
/*  566 */       AchievementInfo.this._xdb_verify_unsafe_();
/*  567 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean isData()
/*      */     {
/*  573 */       return AchievementInfo.this.isData();
/*      */     }
/*      */     
/*      */ 
/*      */     public OctetsStream marshal(OctetsStream _os_)
/*      */     {
/*  579 */       return AchievementInfo.this.marshal(_os_);
/*      */     }
/*      */     
/*      */     public OctetsStream unmarshal(OctetsStream _os_)
/*      */       throws com.goldhuman.Common.Marshal.MarshalException
/*      */     {
/*  585 */       AchievementInfo.this._xdb_verify_unsafe_();
/*  586 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public int getSerializedSize()
/*      */     {
/*  592 */       return AchievementInfo.this.getSerializedSize();
/*      */     }
/*      */     
/*      */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*  598 */       return AchievementInfo.this.marshal(_output_);
/*      */     }
/*      */     
/*      */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*  604 */       AchievementInfo.this._xdb_verify_unsafe_();
/*  605 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xdb.Bean xdbParent()
/*      */     {
/*  611 */       return AchievementInfo.this.xdbParent();
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean xdbManaged()
/*      */     {
/*  617 */       return AchievementInfo.this.xdbManaged();
/*      */     }
/*      */     
/*      */ 
/*      */     public String xdbVarname()
/*      */     {
/*  623 */       return AchievementInfo.this.xdbVarname();
/*      */     }
/*      */     
/*      */ 
/*      */     public Long xdbObjId()
/*      */     {
/*  629 */       return AchievementInfo.this.xdbObjId();
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean equals(Object obj)
/*      */     {
/*  635 */       return AchievementInfo.this.equals(obj);
/*      */     }
/*      */     
/*      */ 
/*      */     public int hashCode()
/*      */     {
/*  641 */       return AchievementInfo.this.hashCode();
/*      */     }
/*      */     
/*      */ 
/*      */     public String toString()
/*      */     {
/*  647 */       return AchievementInfo.this.toString();
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */   public static final class Data
/*      */     implements xbean.AchievementInfo
/*      */   {
/*      */     private int goal_state;
/*      */     
/*      */     private ArrayList<Integer> goal_parameters;
/*      */     
/*      */     private HashMap<Long, String> goal_parameters_extra;
/*      */     
/*      */     private long goal_achieve_time;
/*      */     
/*      */     public void _reset_unsafe_()
/*      */     {
/*  665 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Data()
/*      */     {
/*  670 */       this.goal_parameters = new ArrayList();
/*  671 */       this.goal_parameters_extra = new HashMap();
/*      */     }
/*      */     
/*      */     Data(xbean.AchievementInfo _o1_)
/*      */     {
/*  676 */       if ((_o1_ instanceof AchievementInfo)) { assign((AchievementInfo)_o1_);
/*  677 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  678 */       } else if ((_o1_ instanceof AchievementInfo.Const)) assign(((AchievementInfo.Const)_o1_).nThis()); else {
/*  679 */         throw new UnsupportedOperationException();
/*      */       }
/*      */     }
/*      */     
/*      */     private void assign(AchievementInfo _o_) {
/*  684 */       this.goal_state = _o_.goal_state;
/*  685 */       this.goal_parameters = new ArrayList();
/*  686 */       this.goal_parameters.addAll(_o_.goal_parameters);
/*  687 */       this.goal_parameters_extra = new HashMap();
/*  688 */       for (Map.Entry<Long, String> _e_ : _o_.goal_parameters_extra.entrySet())
/*  689 */         this.goal_parameters_extra.put(_e_.getKey(), _e_.getValue());
/*  690 */       this.goal_achieve_time = _o_.goal_achieve_time;
/*      */     }
/*      */     
/*      */     private void assign(Data _o_)
/*      */     {
/*  695 */       this.goal_state = _o_.goal_state;
/*  696 */       this.goal_parameters = new ArrayList();
/*  697 */       this.goal_parameters.addAll(_o_.goal_parameters);
/*  698 */       this.goal_parameters_extra = new HashMap();
/*  699 */       for (Map.Entry<Long, String> _e_ : _o_.goal_parameters_extra.entrySet())
/*  700 */         this.goal_parameters_extra.put(_e_.getKey(), _e_.getValue());
/*  701 */       this.goal_achieve_time = _o_.goal_achieve_time;
/*      */     }
/*      */     
/*      */ 
/*      */     public final OctetsStream marshal(OctetsStream _os_)
/*      */     {
/*  707 */       _os_.marshal(this.goal_state);
/*  708 */       _os_.compact_uint32(this.goal_parameters.size());
/*  709 */       for (Integer _v_ : this.goal_parameters)
/*      */       {
/*  711 */         _os_.marshal(_v_.intValue());
/*      */       }
/*  713 */       _os_.compact_uint32(this.goal_parameters_extra.size());
/*  714 */       for (Map.Entry<Long, String> _e_ : this.goal_parameters_extra.entrySet())
/*      */       {
/*  716 */         _os_.marshal(((Long)_e_.getKey()).longValue());
/*  717 */         _os_.marshal((String)_e_.getValue(), "UTF-16LE");
/*      */       }
/*  719 */       _os_.marshal(this.goal_achieve_time);
/*  720 */       return _os_;
/*      */     }
/*      */     
/*      */     public final OctetsStream unmarshal(OctetsStream _os_)
/*      */       throws com.goldhuman.Common.Marshal.MarshalException
/*      */     {
/*  726 */       this.goal_state = _os_.unmarshal_int();
/*  727 */       for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*      */       {
/*  729 */         int _v_ = 0;
/*  730 */         _v_ = _os_.unmarshal_int();
/*  731 */         this.goal_parameters.add(Integer.valueOf(_v_));
/*      */       }
/*      */       
/*  734 */       int size = _os_.uncompact_uint32();
/*  735 */       if (size >= 12)
/*      */       {
/*  737 */         this.goal_parameters_extra = new HashMap(size * 2);
/*      */       }
/*  739 */       for (; size > 0; size--)
/*      */       {
/*  741 */         long _k_ = 0L;
/*  742 */         _k_ = _os_.unmarshal_long();
/*  743 */         String _v_ = "";
/*  744 */         _v_ = _os_.unmarshal_String("UTF-16LE");
/*  745 */         this.goal_parameters_extra.put(Long.valueOf(_k_), _v_);
/*      */       }
/*      */       
/*  748 */       this.goal_achieve_time = _os_.unmarshal_long();
/*  749 */       return _os_;
/*      */     }
/*      */     
/*      */ 
/*      */     public final int getSerializedSize()
/*      */     {
/*  755 */       int _size_ = 0;
/*  756 */       _size_ += CodedOutputStream.computeInt32Size(1, this.goal_state);
/*  757 */       for (Integer _v_ : this.goal_parameters)
/*      */       {
/*  759 */         _size_ += CodedOutputStream.computeInt32Size(2, _v_.intValue());
/*      */       }
/*  761 */       for (Map.Entry<Long, String> _e_ : this.goal_parameters_extra.entrySet())
/*      */       {
/*  763 */         _size_ += CodedOutputStream.computeInt64Size(3, ((Long)_e_.getKey()).longValue());
/*      */         try
/*      */         {
/*  766 */           _size_ += CodedOutputStream.computeBytesSize(3, ppbio.ByteString.copyFrom((String)_e_.getValue(), "UTF-16LE"));
/*      */         }
/*      */         catch (java.io.UnsupportedEncodingException e)
/*      */         {
/*  770 */           throw new RuntimeException("UTF-16LE not supported?", e);
/*      */         }
/*      */       }
/*  773 */       _size_ += CodedOutputStream.computeInt64Size(4, this.goal_achieve_time);
/*  774 */       return _size_;
/*      */     }
/*      */     
/*      */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*      */       try
/*      */       {
/*  782 */         _output_.writeInt32(1, this.goal_state);
/*  783 */         for (Integer _v_ : this.goal_parameters)
/*      */         {
/*  785 */           _output_.writeInt32(2, _v_.intValue());
/*      */         }
/*  787 */         for (Map.Entry<Long, String> _e_ : this.goal_parameters_extra.entrySet())
/*      */         {
/*  789 */           _output_.writeInt64(3, ((Long)_e_.getKey()).longValue());
/*  790 */           _output_.writeBytes(3, ppbio.ByteString.copyFrom((String)_e_.getValue(), "UTF-16LE"));
/*      */         }
/*  792 */         _output_.writeInt64(4, this.goal_achieve_time);
/*      */       }
/*      */       catch (java.io.IOException e)
/*      */       {
/*  796 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */       }
/*  798 */       return _output_;
/*      */     }
/*      */     
/*      */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*      */       try
/*      */       {
/*  806 */         boolean done = false;
/*  807 */         while (!done)
/*      */         {
/*  809 */           int tag = _input_.readTag();
/*  810 */           switch (tag)
/*      */           {
/*      */ 
/*      */           case 0: 
/*  814 */             done = true;
/*  815 */             break;
/*      */           
/*      */ 
/*      */           case 8: 
/*  819 */             this.goal_state = _input_.readInt32();
/*  820 */             break;
/*      */           
/*      */ 
/*      */           case 16: 
/*  824 */             int _v_ = 0;
/*  825 */             _v_ = _input_.readInt32();
/*  826 */             this.goal_parameters.add(Integer.valueOf(_v_));
/*  827 */             break;
/*      */           
/*      */ 
/*      */           case 24: 
/*  831 */             long _k_ = 0L;
/*  832 */             _k_ = _input_.readInt64();
/*  833 */             int readTag = _input_.readTag();
/*  834 */             if (26 != readTag)
/*      */             {
/*  836 */               throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*      */             }
/*  838 */             String _v_ = "";
/*  839 */             _v_ = _input_.readBytes().toString("UTF-16LE");
/*  840 */             this.goal_parameters_extra.put(Long.valueOf(_k_), _v_);
/*  841 */             break;
/*      */           
/*      */ 
/*      */           case 32: 
/*  845 */             this.goal_achieve_time = _input_.readInt64();
/*  846 */             break;
/*      */           
/*      */ 
/*      */           default: 
/*  850 */             if (!CodedInputStream.skipUnknownField(tag, _input_))
/*      */             {
/*  852 */               done = true;
/*      */             }
/*      */             break;
/*      */           }
/*      */           
/*      */         }
/*      */       }
/*      */       catch (InvalidProtocolBufferException e)
/*      */       {
/*  861 */         throw e.setUnfinishedMessage(this);
/*      */       }
/*      */       catch (java.io.IOException e)
/*      */       {
/*  865 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */       }
/*  867 */       return _input_;
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.AchievementInfo copy()
/*      */     {
/*  873 */       return new Data(this);
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.AchievementInfo toData()
/*      */     {
/*  879 */       return new Data(this);
/*      */     }
/*      */     
/*      */     public xbean.AchievementInfo toBean()
/*      */     {
/*  884 */       return new AchievementInfo(this, null, null);
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.AchievementInfo toDataIf()
/*      */     {
/*  890 */       return this;
/*      */     }
/*      */     
/*      */     public xbean.AchievementInfo toBeanIf()
/*      */     {
/*  895 */       return new AchievementInfo(this, null, null);
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean xdbManaged()
/*      */     {
/*  901 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public xdb.Bean xdbParent() {
/*  905 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public String xdbVarname() {
/*  909 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Long xdbObjId() {
/*  913 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public xdb.Bean toConst() {
/*  917 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public boolean isConst() {
/*  921 */       return false;
/*      */     }
/*      */     
/*      */     public boolean isData() {
/*  925 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getGoal_state()
/*      */     {
/*  932 */       return this.goal_state;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public List<Integer> getGoal_parameters()
/*      */     {
/*  939 */       return this.goal_parameters;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public List<Integer> getGoal_parametersAsData()
/*      */     {
/*  946 */       return this.goal_parameters;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Long, String> getGoal_parameters_extra()
/*      */     {
/*  953 */       return this.goal_parameters_extra;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Long, String> getGoal_parameters_extraAsData()
/*      */     {
/*  960 */       return this.goal_parameters_extra;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getGoal_achieve_time()
/*      */     {
/*  967 */       return this.goal_achieve_time;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setGoal_state(int _v_)
/*      */     {
/*  974 */       this.goal_state = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setGoal_achieve_time(long _v_)
/*      */     {
/*  981 */       this.goal_achieve_time = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */     public final boolean equals(Object _o1_)
/*      */     {
/*  987 */       if (!(_o1_ instanceof Data)) return false;
/*  988 */       Data _o_ = (Data)_o1_;
/*  989 */       if (this.goal_state != _o_.goal_state) return false;
/*  990 */       if (!this.goal_parameters.equals(_o_.goal_parameters)) return false;
/*  991 */       if (!this.goal_parameters_extra.equals(_o_.goal_parameters_extra)) return false;
/*  992 */       if (this.goal_achieve_time != _o_.goal_achieve_time) return false;
/*  993 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */     public final int hashCode()
/*      */     {
/*  999 */       int _h_ = 0;
/* 1000 */       _h_ += this.goal_state;
/* 1001 */       _h_ += this.goal_parameters.hashCode();
/* 1002 */       _h_ += this.goal_parameters_extra.hashCode();
/* 1003 */       _h_ = (int)(_h_ + this.goal_achieve_time);
/* 1004 */       return _h_;
/*      */     }
/*      */     
/*      */ 
/*      */     public String toString()
/*      */     {
/* 1010 */       StringBuilder _sb_ = new StringBuilder();
/* 1011 */       _sb_.append("(");
/* 1012 */       _sb_.append(this.goal_state);
/* 1013 */       _sb_.append(",");
/* 1014 */       _sb_.append(this.goal_parameters);
/* 1015 */       _sb_.append(",");
/* 1016 */       _sb_.append(this.goal_parameters_extra);
/* 1017 */       _sb_.append(",");
/* 1018 */       _sb_.append(this.goal_achieve_time);
/* 1019 */       _sb_.append(")");
/* 1020 */       return _sb_.toString();
/*      */     }
/*      */   }
/*      */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\AchievementInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */