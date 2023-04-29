/*      */ package xbean.__;
/*      */ 
/*      */ import com.goldhuman.Common.Marshal.OctetsStream;
/*      */ import java.io.IOException;
/*      */ import java.util.HashMap;
/*      */ import java.util.Map;
/*      */ import java.util.Map.Entry;
/*      */ import ppbio.CodedInputStream;
/*      */ import ppbio.CodedOutputStream;
/*      */ import ppbio.InvalidProtocolBufferException;
/*      */ import xdb.LogKey;
/*      */ import xdb.XBean;
/*      */ import xdb.logs.ListenableBean;
/*      */ import xdb.logs.ListenableChanged;
/*      */ import xdb.logs.LogLong;
/*      */ 
/*      */ public final class RoleSingleCrossFieldInfo extends XBean implements xbean.RoleSingleCrossFieldInfo
/*      */ {
/*      */   private long active_leave_field_timestamp;
/*      */   private HashMap<Integer, xbean.RoleSingleCrossFieldSeasonInfo> season_infos;
/*      */   private int weekly_point_sum;
/*      */   private long weekly_point_sum_timestamp;
/*      */   private int daily_award_times;
/*      */   private long daily_award_times_timestamp;
/*      */   
/*      */   public void _reset_unsafe_()
/*      */   {
/*   28 */     this.active_leave_field_timestamp = 0L;
/*   29 */     this.season_infos.clear();
/*   30 */     this.weekly_point_sum = 0;
/*   31 */     this.weekly_point_sum_timestamp = 0L;
/*   32 */     this.daily_award_times = 0;
/*   33 */     this.daily_award_times_timestamp = 0L;
/*      */   }
/*      */   
/*      */   RoleSingleCrossFieldInfo(int __, XBean _xp_, String _vn_)
/*      */   {
/*   38 */     super(_xp_, _vn_);
/*   39 */     this.active_leave_field_timestamp = 0L;
/*   40 */     this.season_infos = new HashMap();
/*   41 */     this.weekly_point_sum = 0;
/*   42 */     this.weekly_point_sum_timestamp = 0L;
/*   43 */     this.daily_award_times = 0;
/*   44 */     this.daily_award_times_timestamp = 0L;
/*      */   }
/*      */   
/*      */   public RoleSingleCrossFieldInfo()
/*      */   {
/*   49 */     this(0, null, null);
/*      */   }
/*      */   
/*      */   public RoleSingleCrossFieldInfo(RoleSingleCrossFieldInfo _o_)
/*      */   {
/*   54 */     this(_o_, null, null);
/*      */   }
/*      */   
/*      */   RoleSingleCrossFieldInfo(xbean.RoleSingleCrossFieldInfo _o1_, XBean _xp_, String _vn_)
/*      */   {
/*   59 */     super(_xp_, _vn_);
/*   60 */     if ((_o1_ instanceof RoleSingleCrossFieldInfo)) { assign((RoleSingleCrossFieldInfo)_o1_);
/*   61 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*   62 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*   63 */       throw new UnsupportedOperationException();
/*      */     }
/*      */   }
/*      */   
/*      */   private void assign(RoleSingleCrossFieldInfo _o_) {
/*   68 */     _o_._xdb_verify_unsafe_();
/*   69 */     this.active_leave_field_timestamp = _o_.active_leave_field_timestamp;
/*   70 */     this.season_infos = new HashMap();
/*   71 */     for (Map.Entry<Integer, xbean.RoleSingleCrossFieldSeasonInfo> _e_ : _o_.season_infos.entrySet())
/*   72 */       this.season_infos.put(_e_.getKey(), new RoleSingleCrossFieldSeasonInfo((xbean.RoleSingleCrossFieldSeasonInfo)_e_.getValue(), this, "season_infos"));
/*   73 */     this.weekly_point_sum = _o_.weekly_point_sum;
/*   74 */     this.weekly_point_sum_timestamp = _o_.weekly_point_sum_timestamp;
/*   75 */     this.daily_award_times = _o_.daily_award_times;
/*   76 */     this.daily_award_times_timestamp = _o_.daily_award_times_timestamp;
/*      */   }
/*      */   
/*      */   private void assign(Data _o_)
/*      */   {
/*   81 */     this.active_leave_field_timestamp = _o_.active_leave_field_timestamp;
/*   82 */     this.season_infos = new HashMap();
/*   83 */     for (Map.Entry<Integer, xbean.RoleSingleCrossFieldSeasonInfo> _e_ : _o_.season_infos.entrySet())
/*   84 */       this.season_infos.put(_e_.getKey(), new RoleSingleCrossFieldSeasonInfo((xbean.RoleSingleCrossFieldSeasonInfo)_e_.getValue(), this, "season_infos"));
/*   85 */     this.weekly_point_sum = _o_.weekly_point_sum;
/*   86 */     this.weekly_point_sum_timestamp = _o_.weekly_point_sum_timestamp;
/*   87 */     this.daily_award_times = _o_.daily_award_times;
/*   88 */     this.daily_award_times_timestamp = _o_.daily_award_times_timestamp;
/*      */   }
/*      */   
/*      */ 
/*      */   public final OctetsStream marshal(OctetsStream _os_)
/*      */   {
/*   94 */     _xdb_verify_unsafe_();
/*   95 */     _os_.marshal(this.active_leave_field_timestamp);
/*   96 */     _os_.compact_uint32(this.season_infos.size());
/*   97 */     for (Map.Entry<Integer, xbean.RoleSingleCrossFieldSeasonInfo> _e_ : this.season_infos.entrySet())
/*      */     {
/*   99 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/*  100 */       ((xbean.RoleSingleCrossFieldSeasonInfo)_e_.getValue()).marshal(_os_);
/*      */     }
/*  102 */     _os_.marshal(this.weekly_point_sum);
/*  103 */     _os_.marshal(this.weekly_point_sum_timestamp);
/*  104 */     _os_.marshal(this.daily_award_times);
/*  105 */     _os_.marshal(this.daily_award_times_timestamp);
/*  106 */     return _os_;
/*      */   }
/*      */   
/*      */   public final OctetsStream unmarshal(OctetsStream _os_)
/*      */     throws com.goldhuman.Common.Marshal.MarshalException
/*      */   {
/*  112 */     _xdb_verify_unsafe_();
/*  113 */     this.active_leave_field_timestamp = _os_.unmarshal_long();
/*      */     
/*  115 */     int size = _os_.uncompact_uint32();
/*  116 */     if (size >= 12)
/*      */     {
/*  118 */       this.season_infos = new HashMap(size * 2);
/*      */     }
/*  120 */     for (; size > 0; size--)
/*      */     {
/*  122 */       int _k_ = 0;
/*  123 */       _k_ = _os_.unmarshal_int();
/*  124 */       xbean.RoleSingleCrossFieldSeasonInfo _v_ = new RoleSingleCrossFieldSeasonInfo(0, this, "season_infos");
/*  125 */       _v_.unmarshal(_os_);
/*  126 */       this.season_infos.put(Integer.valueOf(_k_), _v_);
/*      */     }
/*      */     
/*  129 */     this.weekly_point_sum = _os_.unmarshal_int();
/*  130 */     this.weekly_point_sum_timestamp = _os_.unmarshal_long();
/*  131 */     this.daily_award_times = _os_.unmarshal_int();
/*  132 */     this.daily_award_times_timestamp = _os_.unmarshal_long();
/*  133 */     return _os_;
/*      */   }
/*      */   
/*      */ 
/*      */   public int getSerializedSize()
/*      */   {
/*  139 */     _xdb_verify_unsafe_();
/*  140 */     int _size_ = 0;
/*  141 */     _size_ += CodedOutputStream.computeInt64Size(1, this.active_leave_field_timestamp);
/*  142 */     for (Map.Entry<Integer, xbean.RoleSingleCrossFieldSeasonInfo> _e_ : this.season_infos.entrySet())
/*      */     {
/*  144 */       _size_ += CodedOutputStream.computeInt32Size(2, ((Integer)_e_.getKey()).intValue());
/*  145 */       _size_ += CodedOutputStream.computeMessageSize(2, (ppbio.Message)_e_.getValue());
/*      */     }
/*  147 */     _size_ += CodedOutputStream.computeInt32Size(3, this.weekly_point_sum);
/*  148 */     _size_ += CodedOutputStream.computeInt64Size(4, this.weekly_point_sum_timestamp);
/*  149 */     _size_ += CodedOutputStream.computeInt32Size(5, this.daily_award_times);
/*  150 */     _size_ += CodedOutputStream.computeInt64Size(6, this.daily_award_times_timestamp);
/*  151 */     return _size_;
/*      */   }
/*      */   
/*      */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */     throws InvalidProtocolBufferException
/*      */   {
/*  157 */     _xdb_verify_unsafe_();
/*      */     try
/*      */     {
/*  160 */       _output_.writeInt64(1, this.active_leave_field_timestamp);
/*  161 */       for (Map.Entry<Integer, xbean.RoleSingleCrossFieldSeasonInfo> _e_ : this.season_infos.entrySet())
/*      */       {
/*  163 */         _output_.writeInt32(2, ((Integer)_e_.getKey()).intValue());
/*  164 */         _output_.writeMessage(2, (ppbio.Message)_e_.getValue());
/*      */       }
/*  166 */       _output_.writeInt32(3, this.weekly_point_sum);
/*  167 */       _output_.writeInt64(4, this.weekly_point_sum_timestamp);
/*  168 */       _output_.writeInt32(5, this.daily_award_times);
/*  169 */       _output_.writeInt64(6, this.daily_award_times_timestamp);
/*      */     }
/*      */     catch (IOException e)
/*      */     {
/*  173 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */     }
/*  175 */     return _output_;
/*      */   }
/*      */   
/*      */   public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */     throws InvalidProtocolBufferException
/*      */   {
/*  181 */     _xdb_verify_unsafe_();
/*      */     try
/*      */     {
/*  184 */       boolean done = false;
/*  185 */       while (!done)
/*      */       {
/*  187 */         int tag = _input_.readTag();
/*  188 */         switch (tag)
/*      */         {
/*      */ 
/*      */         case 0: 
/*  192 */           done = true;
/*  193 */           break;
/*      */         
/*      */ 
/*      */         case 8: 
/*  197 */           this.active_leave_field_timestamp = _input_.readInt64();
/*  198 */           break;
/*      */         
/*      */ 
/*      */         case 16: 
/*  202 */           int _k_ = 0;
/*  203 */           _k_ = _input_.readInt32();
/*  204 */           int readTag = _input_.readTag();
/*  205 */           if (18 != readTag)
/*      */           {
/*  207 */             throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*      */           }
/*  209 */           xbean.RoleSingleCrossFieldSeasonInfo _v_ = new RoleSingleCrossFieldSeasonInfo(0, this, "season_infos");
/*  210 */           _input_.readMessage(_v_);
/*  211 */           this.season_infos.put(Integer.valueOf(_k_), _v_);
/*  212 */           break;
/*      */         
/*      */ 
/*      */         case 24: 
/*  216 */           this.weekly_point_sum = _input_.readInt32();
/*  217 */           break;
/*      */         
/*      */ 
/*      */         case 32: 
/*  221 */           this.weekly_point_sum_timestamp = _input_.readInt64();
/*  222 */           break;
/*      */         
/*      */ 
/*      */         case 40: 
/*  226 */           this.daily_award_times = _input_.readInt32();
/*  227 */           break;
/*      */         
/*      */ 
/*      */         case 48: 
/*  231 */           this.daily_award_times_timestamp = _input_.readInt64();
/*  232 */           break;
/*      */         
/*      */ 
/*      */         default: 
/*  236 */           if (!CodedInputStream.skipUnknownField(tag, _input_))
/*      */           {
/*  238 */             done = true;
/*      */           }
/*      */           break;
/*      */         }
/*      */         
/*      */       }
/*      */     }
/*      */     catch (InvalidProtocolBufferException e)
/*      */     {
/*  247 */       throw e.setUnfinishedMessage(this);
/*      */     }
/*      */     catch (IOException e)
/*      */     {
/*  251 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */     }
/*  253 */     return _input_;
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.RoleSingleCrossFieldInfo copy()
/*      */   {
/*  259 */     _xdb_verify_unsafe_();
/*  260 */     return new RoleSingleCrossFieldInfo(this);
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.RoleSingleCrossFieldInfo toData()
/*      */   {
/*  266 */     _xdb_verify_unsafe_();
/*  267 */     return new Data(this);
/*      */   }
/*      */   
/*      */   public xbean.RoleSingleCrossFieldInfo toBean()
/*      */   {
/*  272 */     _xdb_verify_unsafe_();
/*  273 */     return new RoleSingleCrossFieldInfo(this);
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.RoleSingleCrossFieldInfo toDataIf()
/*      */   {
/*  279 */     _xdb_verify_unsafe_();
/*  280 */     return new Data(this);
/*      */   }
/*      */   
/*      */   public xbean.RoleSingleCrossFieldInfo toBeanIf()
/*      */   {
/*  285 */     _xdb_verify_unsafe_();
/*  286 */     return this;
/*      */   }
/*      */   
/*      */ 
/*      */   public xdb.Bean toConst()
/*      */   {
/*  292 */     _xdb_verify_unsafe_();
/*  293 */     return new Const(null);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public long getActive_leave_field_timestamp()
/*      */   {
/*  300 */     _xdb_verify_unsafe_();
/*  301 */     return this.active_leave_field_timestamp;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<Integer, xbean.RoleSingleCrossFieldSeasonInfo> getSeason_infos()
/*      */   {
/*  308 */     _xdb_verify_unsafe_();
/*  309 */     return xdb.Logs.logMap(new LogKey(this, "season_infos"), this.season_infos);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<Integer, xbean.RoleSingleCrossFieldSeasonInfo> getSeason_infosAsData()
/*      */   {
/*  316 */     _xdb_verify_unsafe_();
/*      */     
/*  318 */     RoleSingleCrossFieldInfo _o_ = this;
/*  319 */     Map<Integer, xbean.RoleSingleCrossFieldSeasonInfo> season_infos = new HashMap();
/*  320 */     for (Map.Entry<Integer, xbean.RoleSingleCrossFieldSeasonInfo> _e_ : _o_.season_infos.entrySet())
/*  321 */       season_infos.put(_e_.getKey(), new RoleSingleCrossFieldSeasonInfo.Data((xbean.RoleSingleCrossFieldSeasonInfo)_e_.getValue()));
/*  322 */     return season_infos;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getWeekly_point_sum()
/*      */   {
/*  329 */     _xdb_verify_unsafe_();
/*  330 */     return this.weekly_point_sum;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public long getWeekly_point_sum_timestamp()
/*      */   {
/*  337 */     _xdb_verify_unsafe_();
/*  338 */     return this.weekly_point_sum_timestamp;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getDaily_award_times()
/*      */   {
/*  345 */     _xdb_verify_unsafe_();
/*  346 */     return this.daily_award_times;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public long getDaily_award_times_timestamp()
/*      */   {
/*  353 */     _xdb_verify_unsafe_();
/*  354 */     return this.daily_award_times_timestamp;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setActive_leave_field_timestamp(long _v_)
/*      */   {
/*  361 */     _xdb_verify_unsafe_();
/*  362 */     xdb.Logs.logIf(new LogKey(this, "active_leave_field_timestamp")
/*      */     {
/*      */       protected xdb.Log create()
/*      */       {
/*  366 */         new LogLong(this, RoleSingleCrossFieldInfo.this.active_leave_field_timestamp)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  370 */             RoleSingleCrossFieldInfo.this.active_leave_field_timestamp = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  374 */     });
/*  375 */     this.active_leave_field_timestamp = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setWeekly_point_sum(int _v_)
/*      */   {
/*  382 */     _xdb_verify_unsafe_();
/*  383 */     xdb.Logs.logIf(new LogKey(this, "weekly_point_sum")
/*      */     {
/*      */       protected xdb.Log create()
/*      */       {
/*  387 */         new xdb.logs.LogInt(this, RoleSingleCrossFieldInfo.this.weekly_point_sum)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  391 */             RoleSingleCrossFieldInfo.this.weekly_point_sum = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  395 */     });
/*  396 */     this.weekly_point_sum = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setWeekly_point_sum_timestamp(long _v_)
/*      */   {
/*  403 */     _xdb_verify_unsafe_();
/*  404 */     xdb.Logs.logIf(new LogKey(this, "weekly_point_sum_timestamp")
/*      */     {
/*      */       protected xdb.Log create()
/*      */       {
/*  408 */         new LogLong(this, RoleSingleCrossFieldInfo.this.weekly_point_sum_timestamp)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  412 */             RoleSingleCrossFieldInfo.this.weekly_point_sum_timestamp = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  416 */     });
/*  417 */     this.weekly_point_sum_timestamp = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setDaily_award_times(int _v_)
/*      */   {
/*  424 */     _xdb_verify_unsafe_();
/*  425 */     xdb.Logs.logIf(new LogKey(this, "daily_award_times")
/*      */     {
/*      */       protected xdb.Log create()
/*      */       {
/*  429 */         new xdb.logs.LogInt(this, RoleSingleCrossFieldInfo.this.daily_award_times)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  433 */             RoleSingleCrossFieldInfo.this.daily_award_times = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  437 */     });
/*  438 */     this.daily_award_times = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setDaily_award_times_timestamp(long _v_)
/*      */   {
/*  445 */     _xdb_verify_unsafe_();
/*  446 */     xdb.Logs.logIf(new LogKey(this, "daily_award_times_timestamp")
/*      */     {
/*      */       protected xdb.Log create()
/*      */       {
/*  450 */         new LogLong(this, RoleSingleCrossFieldInfo.this.daily_award_times_timestamp)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  454 */             RoleSingleCrossFieldInfo.this.daily_award_times_timestamp = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  458 */     });
/*  459 */     this.daily_award_times_timestamp = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */   public final boolean equals(Object _o1_)
/*      */   {
/*  465 */     _xdb_verify_unsafe_();
/*  466 */     RoleSingleCrossFieldInfo _o_ = null;
/*  467 */     if ((_o1_ instanceof RoleSingleCrossFieldInfo)) { _o_ = (RoleSingleCrossFieldInfo)_o1_;
/*  468 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/*  469 */       return false;
/*  470 */     if (this.active_leave_field_timestamp != _o_.active_leave_field_timestamp) return false;
/*  471 */     if (!this.season_infos.equals(_o_.season_infos)) return false;
/*  472 */     if (this.weekly_point_sum != _o_.weekly_point_sum) return false;
/*  473 */     if (this.weekly_point_sum_timestamp != _o_.weekly_point_sum_timestamp) return false;
/*  474 */     if (this.daily_award_times != _o_.daily_award_times) return false;
/*  475 */     if (this.daily_award_times_timestamp != _o_.daily_award_times_timestamp) return false;
/*  476 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */   public final int hashCode()
/*      */   {
/*  482 */     _xdb_verify_unsafe_();
/*  483 */     int _h_ = 0;
/*  484 */     _h_ = (int)(_h_ + this.active_leave_field_timestamp);
/*  485 */     _h_ += this.season_infos.hashCode();
/*  486 */     _h_ += this.weekly_point_sum;
/*  487 */     _h_ = (int)(_h_ + this.weekly_point_sum_timestamp);
/*  488 */     _h_ += this.daily_award_times;
/*  489 */     _h_ = (int)(_h_ + this.daily_award_times_timestamp);
/*  490 */     return _h_;
/*      */   }
/*      */   
/*      */ 
/*      */   public String toString()
/*      */   {
/*  496 */     _xdb_verify_unsafe_();
/*  497 */     StringBuilder _sb_ = new StringBuilder();
/*  498 */     _sb_.append("(");
/*  499 */     _sb_.append(this.active_leave_field_timestamp);
/*  500 */     _sb_.append(",");
/*  501 */     _sb_.append(this.season_infos);
/*  502 */     _sb_.append(",");
/*  503 */     _sb_.append(this.weekly_point_sum);
/*  504 */     _sb_.append(",");
/*  505 */     _sb_.append(this.weekly_point_sum_timestamp);
/*  506 */     _sb_.append(",");
/*  507 */     _sb_.append(this.daily_award_times);
/*  508 */     _sb_.append(",");
/*  509 */     _sb_.append(this.daily_award_times_timestamp);
/*  510 */     _sb_.append(")");
/*  511 */     return _sb_.toString();
/*      */   }
/*      */   
/*      */ 
/*      */   public xdb.logs.Listenable newListenable()
/*      */   {
/*  517 */     ListenableBean lb = new ListenableBean();
/*  518 */     lb.add(new ListenableChanged().setVarName("active_leave_field_timestamp"));
/*  519 */     lb.add(new xdb.logs.ListenableMap().setVarName("season_infos"));
/*  520 */     lb.add(new ListenableChanged().setVarName("weekly_point_sum"));
/*  521 */     lb.add(new ListenableChanged().setVarName("weekly_point_sum_timestamp"));
/*  522 */     lb.add(new ListenableChanged().setVarName("daily_award_times"));
/*  523 */     lb.add(new ListenableChanged().setVarName("daily_award_times_timestamp"));
/*  524 */     return lb;
/*      */   }
/*      */   
/*      */   private class Const implements xbean.RoleSingleCrossFieldInfo {
/*      */     private Const() {}
/*      */     
/*      */     RoleSingleCrossFieldInfo nThis() {
/*  531 */       return RoleSingleCrossFieldInfo.this;
/*      */     }
/*      */     
/*      */ 
/*      */     public void _reset_unsafe_()
/*      */     {
/*  537 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.RoleSingleCrossFieldInfo copy()
/*      */     {
/*  543 */       return RoleSingleCrossFieldInfo.this.copy();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.RoleSingleCrossFieldInfo toData()
/*      */     {
/*  549 */       return RoleSingleCrossFieldInfo.this.toData();
/*      */     }
/*      */     
/*      */     public xbean.RoleSingleCrossFieldInfo toBean()
/*      */     {
/*  554 */       return RoleSingleCrossFieldInfo.this.toBean();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.RoleSingleCrossFieldInfo toDataIf()
/*      */     {
/*  560 */       return RoleSingleCrossFieldInfo.this.toDataIf();
/*      */     }
/*      */     
/*      */     public xbean.RoleSingleCrossFieldInfo toBeanIf()
/*      */     {
/*  565 */       return RoleSingleCrossFieldInfo.this.toBeanIf();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getActive_leave_field_timestamp()
/*      */     {
/*  572 */       RoleSingleCrossFieldInfo.this._xdb_verify_unsafe_();
/*  573 */       return RoleSingleCrossFieldInfo.this.active_leave_field_timestamp;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, xbean.RoleSingleCrossFieldSeasonInfo> getSeason_infos()
/*      */     {
/*  580 */       RoleSingleCrossFieldInfo.this._xdb_verify_unsafe_();
/*  581 */       return xdb.Consts.constMap(RoleSingleCrossFieldInfo.this.season_infos);
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, xbean.RoleSingleCrossFieldSeasonInfo> getSeason_infosAsData()
/*      */     {
/*  588 */       RoleSingleCrossFieldInfo.this._xdb_verify_unsafe_();
/*      */       
/*  590 */       RoleSingleCrossFieldInfo _o_ = RoleSingleCrossFieldInfo.this;
/*  591 */       Map<Integer, xbean.RoleSingleCrossFieldSeasonInfo> season_infos = new HashMap();
/*  592 */       for (Map.Entry<Integer, xbean.RoleSingleCrossFieldSeasonInfo> _e_ : _o_.season_infos.entrySet())
/*  593 */         season_infos.put(_e_.getKey(), new RoleSingleCrossFieldSeasonInfo.Data((xbean.RoleSingleCrossFieldSeasonInfo)_e_.getValue()));
/*  594 */       return season_infos;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getWeekly_point_sum()
/*      */     {
/*  601 */       RoleSingleCrossFieldInfo.this._xdb_verify_unsafe_();
/*  602 */       return RoleSingleCrossFieldInfo.this.weekly_point_sum;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getWeekly_point_sum_timestamp()
/*      */     {
/*  609 */       RoleSingleCrossFieldInfo.this._xdb_verify_unsafe_();
/*  610 */       return RoleSingleCrossFieldInfo.this.weekly_point_sum_timestamp;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getDaily_award_times()
/*      */     {
/*  617 */       RoleSingleCrossFieldInfo.this._xdb_verify_unsafe_();
/*  618 */       return RoleSingleCrossFieldInfo.this.daily_award_times;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getDaily_award_times_timestamp()
/*      */     {
/*  625 */       RoleSingleCrossFieldInfo.this._xdb_verify_unsafe_();
/*  626 */       return RoleSingleCrossFieldInfo.this.daily_award_times_timestamp;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setActive_leave_field_timestamp(long _v_)
/*      */     {
/*  633 */       RoleSingleCrossFieldInfo.this._xdb_verify_unsafe_();
/*  634 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setWeekly_point_sum(int _v_)
/*      */     {
/*  641 */       RoleSingleCrossFieldInfo.this._xdb_verify_unsafe_();
/*  642 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setWeekly_point_sum_timestamp(long _v_)
/*      */     {
/*  649 */       RoleSingleCrossFieldInfo.this._xdb_verify_unsafe_();
/*  650 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setDaily_award_times(int _v_)
/*      */     {
/*  657 */       RoleSingleCrossFieldInfo.this._xdb_verify_unsafe_();
/*  658 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setDaily_award_times_timestamp(long _v_)
/*      */     {
/*  665 */       RoleSingleCrossFieldInfo.this._xdb_verify_unsafe_();
/*  666 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xdb.Bean toConst()
/*      */     {
/*  672 */       RoleSingleCrossFieldInfo.this._xdb_verify_unsafe_();
/*  673 */       return this;
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean isConst()
/*      */     {
/*  679 */       RoleSingleCrossFieldInfo.this._xdb_verify_unsafe_();
/*  680 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean isData()
/*      */     {
/*  686 */       return RoleSingleCrossFieldInfo.this.isData();
/*      */     }
/*      */     
/*      */ 
/*      */     public OctetsStream marshal(OctetsStream _os_)
/*      */     {
/*  692 */       return RoleSingleCrossFieldInfo.this.marshal(_os_);
/*      */     }
/*      */     
/*      */     public OctetsStream unmarshal(OctetsStream _os_)
/*      */       throws com.goldhuman.Common.Marshal.MarshalException
/*      */     {
/*  698 */       RoleSingleCrossFieldInfo.this._xdb_verify_unsafe_();
/*  699 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public int getSerializedSize()
/*      */     {
/*  705 */       return RoleSingleCrossFieldInfo.this.getSerializedSize();
/*      */     }
/*      */     
/*      */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*  711 */       return RoleSingleCrossFieldInfo.this.marshal(_output_);
/*      */     }
/*      */     
/*      */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*  717 */       RoleSingleCrossFieldInfo.this._xdb_verify_unsafe_();
/*  718 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xdb.Bean xdbParent()
/*      */     {
/*  724 */       return RoleSingleCrossFieldInfo.this.xdbParent();
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean xdbManaged()
/*      */     {
/*  730 */       return RoleSingleCrossFieldInfo.this.xdbManaged();
/*      */     }
/*      */     
/*      */ 
/*      */     public String xdbVarname()
/*      */     {
/*  736 */       return RoleSingleCrossFieldInfo.this.xdbVarname();
/*      */     }
/*      */     
/*      */ 
/*      */     public Long xdbObjId()
/*      */     {
/*  742 */       return RoleSingleCrossFieldInfo.this.xdbObjId();
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean equals(Object obj)
/*      */     {
/*  748 */       return RoleSingleCrossFieldInfo.this.equals(obj);
/*      */     }
/*      */     
/*      */ 
/*      */     public int hashCode()
/*      */     {
/*  754 */       return RoleSingleCrossFieldInfo.this.hashCode();
/*      */     }
/*      */     
/*      */ 
/*      */     public String toString()
/*      */     {
/*  760 */       return RoleSingleCrossFieldInfo.this.toString();
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */   public static final class Data
/*      */     implements xbean.RoleSingleCrossFieldInfo
/*      */   {
/*      */     private long active_leave_field_timestamp;
/*      */     
/*      */     private HashMap<Integer, xbean.RoleSingleCrossFieldSeasonInfo> season_infos;
/*      */     
/*      */     private int weekly_point_sum;
/*      */     
/*      */     private long weekly_point_sum_timestamp;
/*      */     
/*      */     private int daily_award_times;
/*      */     
/*      */     private long daily_award_times_timestamp;
/*      */     
/*      */     public void _reset_unsafe_()
/*      */     {
/*  782 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Data()
/*      */     {
/*  787 */       this.active_leave_field_timestamp = 0L;
/*  788 */       this.season_infos = new HashMap();
/*  789 */       this.weekly_point_sum = 0;
/*  790 */       this.weekly_point_sum_timestamp = 0L;
/*  791 */       this.daily_award_times = 0;
/*  792 */       this.daily_award_times_timestamp = 0L;
/*      */     }
/*      */     
/*      */     Data(xbean.RoleSingleCrossFieldInfo _o1_)
/*      */     {
/*  797 */       if ((_o1_ instanceof RoleSingleCrossFieldInfo)) { assign((RoleSingleCrossFieldInfo)_o1_);
/*  798 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  799 */       } else if ((_o1_ instanceof RoleSingleCrossFieldInfo.Const)) assign(((RoleSingleCrossFieldInfo.Const)_o1_).nThis()); else {
/*  800 */         throw new UnsupportedOperationException();
/*      */       }
/*      */     }
/*      */     
/*      */     private void assign(RoleSingleCrossFieldInfo _o_) {
/*  805 */       this.active_leave_field_timestamp = _o_.active_leave_field_timestamp;
/*  806 */       this.season_infos = new HashMap();
/*  807 */       for (Map.Entry<Integer, xbean.RoleSingleCrossFieldSeasonInfo> _e_ : _o_.season_infos.entrySet())
/*  808 */         this.season_infos.put(_e_.getKey(), new RoleSingleCrossFieldSeasonInfo.Data((xbean.RoleSingleCrossFieldSeasonInfo)_e_.getValue()));
/*  809 */       this.weekly_point_sum = _o_.weekly_point_sum;
/*  810 */       this.weekly_point_sum_timestamp = _o_.weekly_point_sum_timestamp;
/*  811 */       this.daily_award_times = _o_.daily_award_times;
/*  812 */       this.daily_award_times_timestamp = _o_.daily_award_times_timestamp;
/*      */     }
/*      */     
/*      */     private void assign(Data _o_)
/*      */     {
/*  817 */       this.active_leave_field_timestamp = _o_.active_leave_field_timestamp;
/*  818 */       this.season_infos = new HashMap();
/*  819 */       for (Map.Entry<Integer, xbean.RoleSingleCrossFieldSeasonInfo> _e_ : _o_.season_infos.entrySet())
/*  820 */         this.season_infos.put(_e_.getKey(), new RoleSingleCrossFieldSeasonInfo.Data((xbean.RoleSingleCrossFieldSeasonInfo)_e_.getValue()));
/*  821 */       this.weekly_point_sum = _o_.weekly_point_sum;
/*  822 */       this.weekly_point_sum_timestamp = _o_.weekly_point_sum_timestamp;
/*  823 */       this.daily_award_times = _o_.daily_award_times;
/*  824 */       this.daily_award_times_timestamp = _o_.daily_award_times_timestamp;
/*      */     }
/*      */     
/*      */ 
/*      */     public final OctetsStream marshal(OctetsStream _os_)
/*      */     {
/*  830 */       _os_.marshal(this.active_leave_field_timestamp);
/*  831 */       _os_.compact_uint32(this.season_infos.size());
/*  832 */       for (Map.Entry<Integer, xbean.RoleSingleCrossFieldSeasonInfo> _e_ : this.season_infos.entrySet())
/*      */       {
/*  834 */         _os_.marshal(((Integer)_e_.getKey()).intValue());
/*  835 */         ((xbean.RoleSingleCrossFieldSeasonInfo)_e_.getValue()).marshal(_os_);
/*      */       }
/*  837 */       _os_.marshal(this.weekly_point_sum);
/*  838 */       _os_.marshal(this.weekly_point_sum_timestamp);
/*  839 */       _os_.marshal(this.daily_award_times);
/*  840 */       _os_.marshal(this.daily_award_times_timestamp);
/*  841 */       return _os_;
/*      */     }
/*      */     
/*      */     public final OctetsStream unmarshal(OctetsStream _os_)
/*      */       throws com.goldhuman.Common.Marshal.MarshalException
/*      */     {
/*  847 */       this.active_leave_field_timestamp = _os_.unmarshal_long();
/*      */       
/*  849 */       int size = _os_.uncompact_uint32();
/*  850 */       if (size >= 12)
/*      */       {
/*  852 */         this.season_infos = new HashMap(size * 2);
/*      */       }
/*  854 */       for (; size > 0; size--)
/*      */       {
/*  856 */         int _k_ = 0;
/*  857 */         _k_ = _os_.unmarshal_int();
/*  858 */         xbean.RoleSingleCrossFieldSeasonInfo _v_ = xbean.Pod.newRoleSingleCrossFieldSeasonInfoData();
/*  859 */         _v_.unmarshal(_os_);
/*  860 */         this.season_infos.put(Integer.valueOf(_k_), _v_);
/*      */       }
/*      */       
/*  863 */       this.weekly_point_sum = _os_.unmarshal_int();
/*  864 */       this.weekly_point_sum_timestamp = _os_.unmarshal_long();
/*  865 */       this.daily_award_times = _os_.unmarshal_int();
/*  866 */       this.daily_award_times_timestamp = _os_.unmarshal_long();
/*  867 */       return _os_;
/*      */     }
/*      */     
/*      */ 
/*      */     public final int getSerializedSize()
/*      */     {
/*  873 */       int _size_ = 0;
/*  874 */       _size_ += CodedOutputStream.computeInt64Size(1, this.active_leave_field_timestamp);
/*  875 */       for (Map.Entry<Integer, xbean.RoleSingleCrossFieldSeasonInfo> _e_ : this.season_infos.entrySet())
/*      */       {
/*  877 */         _size_ += CodedOutputStream.computeInt32Size(2, ((Integer)_e_.getKey()).intValue());
/*  878 */         _size_ += CodedOutputStream.computeMessageSize(2, (ppbio.Message)_e_.getValue());
/*      */       }
/*  880 */       _size_ += CodedOutputStream.computeInt32Size(3, this.weekly_point_sum);
/*  881 */       _size_ += CodedOutputStream.computeInt64Size(4, this.weekly_point_sum_timestamp);
/*  882 */       _size_ += CodedOutputStream.computeInt32Size(5, this.daily_award_times);
/*  883 */       _size_ += CodedOutputStream.computeInt64Size(6, this.daily_award_times_timestamp);
/*  884 */       return _size_;
/*      */     }
/*      */     
/*      */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*      */       try
/*      */       {
/*  892 */         _output_.writeInt64(1, this.active_leave_field_timestamp);
/*  893 */         for (Map.Entry<Integer, xbean.RoleSingleCrossFieldSeasonInfo> _e_ : this.season_infos.entrySet())
/*      */         {
/*  895 */           _output_.writeInt32(2, ((Integer)_e_.getKey()).intValue());
/*  896 */           _output_.writeMessage(2, (ppbio.Message)_e_.getValue());
/*      */         }
/*  898 */         _output_.writeInt32(3, this.weekly_point_sum);
/*  899 */         _output_.writeInt64(4, this.weekly_point_sum_timestamp);
/*  900 */         _output_.writeInt32(5, this.daily_award_times);
/*  901 */         _output_.writeInt64(6, this.daily_award_times_timestamp);
/*      */       }
/*      */       catch (IOException e)
/*      */       {
/*  905 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */       }
/*  907 */       return _output_;
/*      */     }
/*      */     
/*      */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*      */       try
/*      */       {
/*  915 */         boolean done = false;
/*  916 */         while (!done)
/*      */         {
/*  918 */           int tag = _input_.readTag();
/*  919 */           switch (tag)
/*      */           {
/*      */ 
/*      */           case 0: 
/*  923 */             done = true;
/*  924 */             break;
/*      */           
/*      */ 
/*      */           case 8: 
/*  928 */             this.active_leave_field_timestamp = _input_.readInt64();
/*  929 */             break;
/*      */           
/*      */ 
/*      */           case 16: 
/*  933 */             int _k_ = 0;
/*  934 */             _k_ = _input_.readInt32();
/*  935 */             int readTag = _input_.readTag();
/*  936 */             if (18 != readTag)
/*      */             {
/*  938 */               throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*      */             }
/*  940 */             xbean.RoleSingleCrossFieldSeasonInfo _v_ = xbean.Pod.newRoleSingleCrossFieldSeasonInfoData();
/*  941 */             _input_.readMessage(_v_);
/*  942 */             this.season_infos.put(Integer.valueOf(_k_), _v_);
/*  943 */             break;
/*      */           
/*      */ 
/*      */           case 24: 
/*  947 */             this.weekly_point_sum = _input_.readInt32();
/*  948 */             break;
/*      */           
/*      */ 
/*      */           case 32: 
/*  952 */             this.weekly_point_sum_timestamp = _input_.readInt64();
/*  953 */             break;
/*      */           
/*      */ 
/*      */           case 40: 
/*  957 */             this.daily_award_times = _input_.readInt32();
/*  958 */             break;
/*      */           
/*      */ 
/*      */           case 48: 
/*  962 */             this.daily_award_times_timestamp = _input_.readInt64();
/*  963 */             break;
/*      */           
/*      */ 
/*      */           default: 
/*  967 */             if (!CodedInputStream.skipUnknownField(tag, _input_))
/*      */             {
/*  969 */               done = true;
/*      */             }
/*      */             break;
/*      */           }
/*      */           
/*      */         }
/*      */       }
/*      */       catch (InvalidProtocolBufferException e)
/*      */       {
/*  978 */         throw e.setUnfinishedMessage(this);
/*      */       }
/*      */       catch (IOException e)
/*      */       {
/*  982 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */       }
/*  984 */       return _input_;
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.RoleSingleCrossFieldInfo copy()
/*      */     {
/*  990 */       return new Data(this);
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.RoleSingleCrossFieldInfo toData()
/*      */     {
/*  996 */       return new Data(this);
/*      */     }
/*      */     
/*      */     public xbean.RoleSingleCrossFieldInfo toBean()
/*      */     {
/* 1001 */       return new RoleSingleCrossFieldInfo(this, null, null);
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.RoleSingleCrossFieldInfo toDataIf()
/*      */     {
/* 1007 */       return this;
/*      */     }
/*      */     
/*      */     public xbean.RoleSingleCrossFieldInfo toBeanIf()
/*      */     {
/* 1012 */       return new RoleSingleCrossFieldInfo(this, null, null);
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean xdbManaged()
/*      */     {
/* 1018 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public xdb.Bean xdbParent() {
/* 1022 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public String xdbVarname() {
/* 1026 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Long xdbObjId() {
/* 1030 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public xdb.Bean toConst() {
/* 1034 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public boolean isConst() {
/* 1038 */       return false;
/*      */     }
/*      */     
/*      */     public boolean isData() {
/* 1042 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getActive_leave_field_timestamp()
/*      */     {
/* 1049 */       return this.active_leave_field_timestamp;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, xbean.RoleSingleCrossFieldSeasonInfo> getSeason_infos()
/*      */     {
/* 1056 */       return this.season_infos;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, xbean.RoleSingleCrossFieldSeasonInfo> getSeason_infosAsData()
/*      */     {
/* 1063 */       return this.season_infos;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getWeekly_point_sum()
/*      */     {
/* 1070 */       return this.weekly_point_sum;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getWeekly_point_sum_timestamp()
/*      */     {
/* 1077 */       return this.weekly_point_sum_timestamp;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getDaily_award_times()
/*      */     {
/* 1084 */       return this.daily_award_times;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getDaily_award_times_timestamp()
/*      */     {
/* 1091 */       return this.daily_award_times_timestamp;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setActive_leave_field_timestamp(long _v_)
/*      */     {
/* 1098 */       this.active_leave_field_timestamp = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setWeekly_point_sum(int _v_)
/*      */     {
/* 1105 */       this.weekly_point_sum = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setWeekly_point_sum_timestamp(long _v_)
/*      */     {
/* 1112 */       this.weekly_point_sum_timestamp = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setDaily_award_times(int _v_)
/*      */     {
/* 1119 */       this.daily_award_times = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setDaily_award_times_timestamp(long _v_)
/*      */     {
/* 1126 */       this.daily_award_times_timestamp = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */     public final boolean equals(Object _o1_)
/*      */     {
/* 1132 */       if (!(_o1_ instanceof Data)) return false;
/* 1133 */       Data _o_ = (Data)_o1_;
/* 1134 */       if (this.active_leave_field_timestamp != _o_.active_leave_field_timestamp) return false;
/* 1135 */       if (!this.season_infos.equals(_o_.season_infos)) return false;
/* 1136 */       if (this.weekly_point_sum != _o_.weekly_point_sum) return false;
/* 1137 */       if (this.weekly_point_sum_timestamp != _o_.weekly_point_sum_timestamp) return false;
/* 1138 */       if (this.daily_award_times != _o_.daily_award_times) return false;
/* 1139 */       if (this.daily_award_times_timestamp != _o_.daily_award_times_timestamp) return false;
/* 1140 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */     public final int hashCode()
/*      */     {
/* 1146 */       int _h_ = 0;
/* 1147 */       _h_ = (int)(_h_ + this.active_leave_field_timestamp);
/* 1148 */       _h_ += this.season_infos.hashCode();
/* 1149 */       _h_ += this.weekly_point_sum;
/* 1150 */       _h_ = (int)(_h_ + this.weekly_point_sum_timestamp);
/* 1151 */       _h_ += this.daily_award_times;
/* 1152 */       _h_ = (int)(_h_ + this.daily_award_times_timestamp);
/* 1153 */       return _h_;
/*      */     }
/*      */     
/*      */ 
/*      */     public String toString()
/*      */     {
/* 1159 */       StringBuilder _sb_ = new StringBuilder();
/* 1160 */       _sb_.append("(");
/* 1161 */       _sb_.append(this.active_leave_field_timestamp);
/* 1162 */       _sb_.append(",");
/* 1163 */       _sb_.append(this.season_infos);
/* 1164 */       _sb_.append(",");
/* 1165 */       _sb_.append(this.weekly_point_sum);
/* 1166 */       _sb_.append(",");
/* 1167 */       _sb_.append(this.weekly_point_sum_timestamp);
/* 1168 */       _sb_.append(",");
/* 1169 */       _sb_.append(this.daily_award_times);
/* 1170 */       _sb_.append(",");
/* 1171 */       _sb_.append(this.daily_award_times_timestamp);
/* 1172 */       _sb_.append(")");
/* 1173 */       return _sb_.toString();
/*      */     }
/*      */   }
/*      */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\RoleSingleCrossFieldInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */