/*      */ package xbean.__;
/*      */ 
/*      */ import com.goldhuman.Common.Marshal.OctetsStream;
/*      */ import java.io.IOException;
/*      */ import java.util.ArrayList;
/*      */ import java.util.List;
/*      */ import ppbio.CodedInputStream;
/*      */ import ppbio.CodedOutputStream;
/*      */ import ppbio.InvalidProtocolBufferException;
/*      */ import xdb.Log;
/*      */ import xdb.LogKey;
/*      */ import xdb.Logs;
/*      */ import xdb.XBean;
/*      */ import xdb.logs.ListenableBean;
/*      */ import xdb.logs.ListenableChanged;
/*      */ import xdb.logs.LogLong;
/*      */ 
/*      */ public final class Role2BackGameInfo extends XBean implements xbean.Role2BackGameInfo
/*      */ {
/*      */   private long back_state_start_time;
/*      */   private int offline_days;
/*      */   private int back_game_level;
/*      */   private long clear_score_time;
/*      */   private ArrayList<Integer> aleardy_awarded_score_index_list;
/*      */   private int active_base_value;
/*      */   private long yuan_bao_save_amt_base_value;
/*      */   
/*      */   public void _reset_unsafe_()
/*      */   {
/*   30 */     this.back_state_start_time = 0L;
/*   31 */     this.offline_days = 0;
/*   32 */     this.back_game_level = 0;
/*   33 */     this.clear_score_time = 0L;
/*   34 */     this.aleardy_awarded_score_index_list.clear();
/*   35 */     this.active_base_value = 0;
/*   36 */     this.yuan_bao_save_amt_base_value = 0L;
/*      */   }
/*      */   
/*      */   Role2BackGameInfo(int __, XBean _xp_, String _vn_)
/*      */   {
/*   41 */     super(_xp_, _vn_);
/*   42 */     this.aleardy_awarded_score_index_list = new ArrayList();
/*      */   }
/*      */   
/*      */   public Role2BackGameInfo()
/*      */   {
/*   47 */     this(0, null, null);
/*      */   }
/*      */   
/*      */   public Role2BackGameInfo(Role2BackGameInfo _o_)
/*      */   {
/*   52 */     this(_o_, null, null);
/*      */   }
/*      */   
/*      */   Role2BackGameInfo(xbean.Role2BackGameInfo _o1_, XBean _xp_, String _vn_)
/*      */   {
/*   57 */     super(_xp_, _vn_);
/*   58 */     if ((_o1_ instanceof Role2BackGameInfo)) { assign((Role2BackGameInfo)_o1_);
/*   59 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*   60 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*   61 */       throw new UnsupportedOperationException();
/*      */     }
/*      */   }
/*      */   
/*      */   private void assign(Role2BackGameInfo _o_) {
/*   66 */     _o_._xdb_verify_unsafe_();
/*   67 */     this.back_state_start_time = _o_.back_state_start_time;
/*   68 */     this.offline_days = _o_.offline_days;
/*   69 */     this.back_game_level = _o_.back_game_level;
/*   70 */     this.clear_score_time = _o_.clear_score_time;
/*   71 */     this.aleardy_awarded_score_index_list = new ArrayList();
/*   72 */     this.aleardy_awarded_score_index_list.addAll(_o_.aleardy_awarded_score_index_list);
/*   73 */     this.active_base_value = _o_.active_base_value;
/*   74 */     this.yuan_bao_save_amt_base_value = _o_.yuan_bao_save_amt_base_value;
/*      */   }
/*      */   
/*      */   private void assign(Data _o_)
/*      */   {
/*   79 */     this.back_state_start_time = _o_.back_state_start_time;
/*   80 */     this.offline_days = _o_.offline_days;
/*   81 */     this.back_game_level = _o_.back_game_level;
/*   82 */     this.clear_score_time = _o_.clear_score_time;
/*   83 */     this.aleardy_awarded_score_index_list = new ArrayList();
/*   84 */     this.aleardy_awarded_score_index_list.addAll(_o_.aleardy_awarded_score_index_list);
/*   85 */     this.active_base_value = _o_.active_base_value;
/*   86 */     this.yuan_bao_save_amt_base_value = _o_.yuan_bao_save_amt_base_value;
/*      */   }
/*      */   
/*      */ 
/*      */   public final OctetsStream marshal(OctetsStream _os_)
/*      */   {
/*   92 */     _xdb_verify_unsafe_();
/*   93 */     _os_.marshal(this.back_state_start_time);
/*   94 */     _os_.marshal(this.offline_days);
/*   95 */     _os_.marshal(this.back_game_level);
/*   96 */     _os_.marshal(this.clear_score_time);
/*   97 */     _os_.compact_uint32(this.aleardy_awarded_score_index_list.size());
/*   98 */     for (Integer _v_ : this.aleardy_awarded_score_index_list)
/*      */     {
/*  100 */       _os_.marshal(_v_.intValue());
/*      */     }
/*  102 */     _os_.marshal(this.active_base_value);
/*  103 */     _os_.marshal(this.yuan_bao_save_amt_base_value);
/*  104 */     return _os_;
/*      */   }
/*      */   
/*      */   public final OctetsStream unmarshal(OctetsStream _os_)
/*      */     throws com.goldhuman.Common.Marshal.MarshalException
/*      */   {
/*  110 */     _xdb_verify_unsafe_();
/*  111 */     this.back_state_start_time = _os_.unmarshal_long();
/*  112 */     this.offline_days = _os_.unmarshal_int();
/*  113 */     this.back_game_level = _os_.unmarshal_int();
/*  114 */     this.clear_score_time = _os_.unmarshal_long();
/*  115 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*      */     {
/*  117 */       int _v_ = 0;
/*  118 */       _v_ = _os_.unmarshal_int();
/*  119 */       this.aleardy_awarded_score_index_list.add(Integer.valueOf(_v_));
/*      */     }
/*  121 */     this.active_base_value = _os_.unmarshal_int();
/*  122 */     this.yuan_bao_save_amt_base_value = _os_.unmarshal_long();
/*  123 */     return _os_;
/*      */   }
/*      */   
/*      */ 
/*      */   public int getSerializedSize()
/*      */   {
/*  129 */     _xdb_verify_unsafe_();
/*  130 */     int _size_ = 0;
/*  131 */     _size_ += CodedOutputStream.computeInt64Size(1, this.back_state_start_time);
/*  132 */     _size_ += CodedOutputStream.computeInt32Size(2, this.offline_days);
/*  133 */     _size_ += CodedOutputStream.computeInt32Size(3, this.back_game_level);
/*  134 */     _size_ += CodedOutputStream.computeInt64Size(5, this.clear_score_time);
/*  135 */     for (Integer _v_ : this.aleardy_awarded_score_index_list)
/*      */     {
/*  137 */       _size_ += CodedOutputStream.computeInt32Size(6, _v_.intValue());
/*      */     }
/*  139 */     _size_ += CodedOutputStream.computeInt32Size(7, this.active_base_value);
/*  140 */     _size_ += CodedOutputStream.computeInt64Size(8, this.yuan_bao_save_amt_base_value);
/*  141 */     return _size_;
/*      */   }
/*      */   
/*      */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */     throws InvalidProtocolBufferException
/*      */   {
/*  147 */     _xdb_verify_unsafe_();
/*      */     try
/*      */     {
/*  150 */       _output_.writeInt64(1, this.back_state_start_time);
/*  151 */       _output_.writeInt32(2, this.offline_days);
/*  152 */       _output_.writeInt32(3, this.back_game_level);
/*  153 */       _output_.writeInt64(5, this.clear_score_time);
/*  154 */       for (Integer _v_ : this.aleardy_awarded_score_index_list)
/*      */       {
/*  156 */         _output_.writeInt32(6, _v_.intValue());
/*      */       }
/*  158 */       _output_.writeInt32(7, this.active_base_value);
/*  159 */       _output_.writeInt64(8, this.yuan_bao_save_amt_base_value);
/*      */     }
/*      */     catch (IOException e)
/*      */     {
/*  163 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */     }
/*  165 */     return _output_;
/*      */   }
/*      */   
/*      */   public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */     throws InvalidProtocolBufferException
/*      */   {
/*  171 */     _xdb_verify_unsafe_();
/*      */     try
/*      */     {
/*  174 */       boolean done = false;
/*  175 */       while (!done)
/*      */       {
/*  177 */         int tag = _input_.readTag();
/*  178 */         switch (tag)
/*      */         {
/*      */ 
/*      */         case 0: 
/*  182 */           done = true;
/*  183 */           break;
/*      */         
/*      */ 
/*      */         case 8: 
/*  187 */           this.back_state_start_time = _input_.readInt64();
/*  188 */           break;
/*      */         
/*      */ 
/*      */         case 16: 
/*  192 */           this.offline_days = _input_.readInt32();
/*  193 */           break;
/*      */         
/*      */ 
/*      */         case 24: 
/*  197 */           this.back_game_level = _input_.readInt32();
/*  198 */           break;
/*      */         
/*      */ 
/*      */         case 40: 
/*  202 */           this.clear_score_time = _input_.readInt64();
/*  203 */           break;
/*      */         
/*      */ 
/*      */         case 48: 
/*  207 */           int _v_ = 0;
/*  208 */           _v_ = _input_.readInt32();
/*  209 */           this.aleardy_awarded_score_index_list.add(Integer.valueOf(_v_));
/*  210 */           break;
/*      */         
/*      */ 
/*      */         case 56: 
/*  214 */           this.active_base_value = _input_.readInt32();
/*  215 */           break;
/*      */         
/*      */ 
/*      */         case 64: 
/*  219 */           this.yuan_bao_save_amt_base_value = _input_.readInt64();
/*  220 */           break;
/*      */         
/*      */ 
/*      */         default: 
/*  224 */           if (!CodedInputStream.skipUnknownField(tag, _input_))
/*      */           {
/*  226 */             done = true;
/*      */           }
/*      */           break;
/*      */         }
/*      */         
/*      */       }
/*      */     }
/*      */     catch (InvalidProtocolBufferException e)
/*      */     {
/*  235 */       throw e.setUnfinishedMessage(this);
/*      */     }
/*      */     catch (IOException e)
/*      */     {
/*  239 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */     }
/*  241 */     return _input_;
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.Role2BackGameInfo copy()
/*      */   {
/*  247 */     _xdb_verify_unsafe_();
/*  248 */     return new Role2BackGameInfo(this);
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.Role2BackGameInfo toData()
/*      */   {
/*  254 */     _xdb_verify_unsafe_();
/*  255 */     return new Data(this);
/*      */   }
/*      */   
/*      */   public xbean.Role2BackGameInfo toBean()
/*      */   {
/*  260 */     _xdb_verify_unsafe_();
/*  261 */     return new Role2BackGameInfo(this);
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.Role2BackGameInfo toDataIf()
/*      */   {
/*  267 */     _xdb_verify_unsafe_();
/*  268 */     return new Data(this);
/*      */   }
/*      */   
/*      */   public xbean.Role2BackGameInfo toBeanIf()
/*      */   {
/*  273 */     _xdb_verify_unsafe_();
/*  274 */     return this;
/*      */   }
/*      */   
/*      */ 
/*      */   public xdb.Bean toConst()
/*      */   {
/*  280 */     _xdb_verify_unsafe_();
/*  281 */     return new Const(null);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public long getBack_state_start_time()
/*      */   {
/*  288 */     _xdb_verify_unsafe_();
/*  289 */     return this.back_state_start_time;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getOffline_days()
/*      */   {
/*  296 */     _xdb_verify_unsafe_();
/*  297 */     return this.offline_days;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getBack_game_level()
/*      */   {
/*  304 */     _xdb_verify_unsafe_();
/*  305 */     return this.back_game_level;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public long getClear_score_time()
/*      */   {
/*  312 */     _xdb_verify_unsafe_();
/*  313 */     return this.clear_score_time;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public List<Integer> getAleardy_awarded_score_index_list()
/*      */   {
/*  320 */     _xdb_verify_unsafe_();
/*  321 */     return Logs.logList(new LogKey(this, "aleardy_awarded_score_index_list"), this.aleardy_awarded_score_index_list);
/*      */   }
/*      */   
/*      */ 
/*      */   public List<Integer> getAleardy_awarded_score_index_listAsData()
/*      */   {
/*  327 */     _xdb_verify_unsafe_();
/*      */     
/*  329 */     Role2BackGameInfo _o_ = this;
/*  330 */     List<Integer> aleardy_awarded_score_index_list = new ArrayList();
/*  331 */     aleardy_awarded_score_index_list.addAll(_o_.aleardy_awarded_score_index_list);
/*  332 */     return aleardy_awarded_score_index_list;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getActive_base_value()
/*      */   {
/*  339 */     _xdb_verify_unsafe_();
/*  340 */     return this.active_base_value;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public long getYuan_bao_save_amt_base_value()
/*      */   {
/*  347 */     _xdb_verify_unsafe_();
/*  348 */     return this.yuan_bao_save_amt_base_value;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setBack_state_start_time(long _v_)
/*      */   {
/*  355 */     _xdb_verify_unsafe_();
/*  356 */     Logs.logIf(new LogKey(this, "back_state_start_time")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  360 */         new LogLong(this, Role2BackGameInfo.this.back_state_start_time)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  364 */             Role2BackGameInfo.this.back_state_start_time = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  368 */     });
/*  369 */     this.back_state_start_time = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setOffline_days(int _v_)
/*      */   {
/*  376 */     _xdb_verify_unsafe_();
/*  377 */     Logs.logIf(new LogKey(this, "offline_days")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  381 */         new xdb.logs.LogInt(this, Role2BackGameInfo.this.offline_days)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  385 */             Role2BackGameInfo.this.offline_days = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  389 */     });
/*  390 */     this.offline_days = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setBack_game_level(int _v_)
/*      */   {
/*  397 */     _xdb_verify_unsafe_();
/*  398 */     Logs.logIf(new LogKey(this, "back_game_level")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  402 */         new xdb.logs.LogInt(this, Role2BackGameInfo.this.back_game_level)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  406 */             Role2BackGameInfo.this.back_game_level = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  410 */     });
/*  411 */     this.back_game_level = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setClear_score_time(long _v_)
/*      */   {
/*  418 */     _xdb_verify_unsafe_();
/*  419 */     Logs.logIf(new LogKey(this, "clear_score_time")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  423 */         new LogLong(this, Role2BackGameInfo.this.clear_score_time)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  427 */             Role2BackGameInfo.this.clear_score_time = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  431 */     });
/*  432 */     this.clear_score_time = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setActive_base_value(int _v_)
/*      */   {
/*  439 */     _xdb_verify_unsafe_();
/*  440 */     Logs.logIf(new LogKey(this, "active_base_value")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  444 */         new xdb.logs.LogInt(this, Role2BackGameInfo.this.active_base_value)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  448 */             Role2BackGameInfo.this.active_base_value = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  452 */     });
/*  453 */     this.active_base_value = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setYuan_bao_save_amt_base_value(long _v_)
/*      */   {
/*  460 */     _xdb_verify_unsafe_();
/*  461 */     Logs.logIf(new LogKey(this, "yuan_bao_save_amt_base_value")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  465 */         new LogLong(this, Role2BackGameInfo.this.yuan_bao_save_amt_base_value)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  469 */             Role2BackGameInfo.this.yuan_bao_save_amt_base_value = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  473 */     });
/*  474 */     this.yuan_bao_save_amt_base_value = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */   public final boolean equals(Object _o1_)
/*      */   {
/*  480 */     _xdb_verify_unsafe_();
/*  481 */     Role2BackGameInfo _o_ = null;
/*  482 */     if ((_o1_ instanceof Role2BackGameInfo)) { _o_ = (Role2BackGameInfo)_o1_;
/*  483 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/*  484 */       return false;
/*  485 */     if (this.back_state_start_time != _o_.back_state_start_time) return false;
/*  486 */     if (this.offline_days != _o_.offline_days) return false;
/*  487 */     if (this.back_game_level != _o_.back_game_level) return false;
/*  488 */     if (this.clear_score_time != _o_.clear_score_time) return false;
/*  489 */     if (!this.aleardy_awarded_score_index_list.equals(_o_.aleardy_awarded_score_index_list)) return false;
/*  490 */     if (this.active_base_value != _o_.active_base_value) return false;
/*  491 */     if (this.yuan_bao_save_amt_base_value != _o_.yuan_bao_save_amt_base_value) return false;
/*  492 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */   public final int hashCode()
/*      */   {
/*  498 */     _xdb_verify_unsafe_();
/*  499 */     int _h_ = 0;
/*  500 */     _h_ = (int)(_h_ + this.back_state_start_time);
/*  501 */     _h_ += this.offline_days;
/*  502 */     _h_ += this.back_game_level;
/*  503 */     _h_ = (int)(_h_ + this.clear_score_time);
/*  504 */     _h_ += this.aleardy_awarded_score_index_list.hashCode();
/*  505 */     _h_ += this.active_base_value;
/*  506 */     _h_ = (int)(_h_ + this.yuan_bao_save_amt_base_value);
/*  507 */     return _h_;
/*      */   }
/*      */   
/*      */ 
/*      */   public String toString()
/*      */   {
/*  513 */     _xdb_verify_unsafe_();
/*  514 */     StringBuilder _sb_ = new StringBuilder();
/*  515 */     _sb_.append("(");
/*  516 */     _sb_.append(this.back_state_start_time);
/*  517 */     _sb_.append(",");
/*  518 */     _sb_.append(this.offline_days);
/*  519 */     _sb_.append(",");
/*  520 */     _sb_.append(this.back_game_level);
/*  521 */     _sb_.append(",");
/*  522 */     _sb_.append(this.clear_score_time);
/*  523 */     _sb_.append(",");
/*  524 */     _sb_.append(this.aleardy_awarded_score_index_list);
/*  525 */     _sb_.append(",");
/*  526 */     _sb_.append(this.active_base_value);
/*  527 */     _sb_.append(",");
/*  528 */     _sb_.append(this.yuan_bao_save_amt_base_value);
/*  529 */     _sb_.append(")");
/*  530 */     return _sb_.toString();
/*      */   }
/*      */   
/*      */ 
/*      */   public xdb.logs.Listenable newListenable()
/*      */   {
/*  536 */     ListenableBean lb = new ListenableBean();
/*  537 */     lb.add(new ListenableChanged().setVarName("back_state_start_time"));
/*  538 */     lb.add(new ListenableChanged().setVarName("offline_days"));
/*  539 */     lb.add(new ListenableChanged().setVarName("back_game_level"));
/*  540 */     lb.add(new ListenableChanged().setVarName("clear_score_time"));
/*  541 */     lb.add(new ListenableChanged().setVarName("aleardy_awarded_score_index_list"));
/*  542 */     lb.add(new ListenableChanged().setVarName("active_base_value"));
/*  543 */     lb.add(new ListenableChanged().setVarName("yuan_bao_save_amt_base_value"));
/*  544 */     return lb;
/*      */   }
/*      */   
/*      */   private class Const implements xbean.Role2BackGameInfo {
/*      */     private Const() {}
/*      */     
/*      */     Role2BackGameInfo nThis() {
/*  551 */       return Role2BackGameInfo.this;
/*      */     }
/*      */     
/*      */ 
/*      */     public void _reset_unsafe_()
/*      */     {
/*  557 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.Role2BackGameInfo copy()
/*      */     {
/*  563 */       return Role2BackGameInfo.this.copy();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.Role2BackGameInfo toData()
/*      */     {
/*  569 */       return Role2BackGameInfo.this.toData();
/*      */     }
/*      */     
/*      */     public xbean.Role2BackGameInfo toBean()
/*      */     {
/*  574 */       return Role2BackGameInfo.this.toBean();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.Role2BackGameInfo toDataIf()
/*      */     {
/*  580 */       return Role2BackGameInfo.this.toDataIf();
/*      */     }
/*      */     
/*      */     public xbean.Role2BackGameInfo toBeanIf()
/*      */     {
/*  585 */       return Role2BackGameInfo.this.toBeanIf();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getBack_state_start_time()
/*      */     {
/*  592 */       Role2BackGameInfo.this._xdb_verify_unsafe_();
/*  593 */       return Role2BackGameInfo.this.back_state_start_time;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getOffline_days()
/*      */     {
/*  600 */       Role2BackGameInfo.this._xdb_verify_unsafe_();
/*  601 */       return Role2BackGameInfo.this.offline_days;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getBack_game_level()
/*      */     {
/*  608 */       Role2BackGameInfo.this._xdb_verify_unsafe_();
/*  609 */       return Role2BackGameInfo.this.back_game_level;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getClear_score_time()
/*      */     {
/*  616 */       Role2BackGameInfo.this._xdb_verify_unsafe_();
/*  617 */       return Role2BackGameInfo.this.clear_score_time;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public List<Integer> getAleardy_awarded_score_index_list()
/*      */     {
/*  624 */       Role2BackGameInfo.this._xdb_verify_unsafe_();
/*  625 */       return xdb.Consts.constList(Role2BackGameInfo.this.aleardy_awarded_score_index_list);
/*      */     }
/*      */     
/*      */ 
/*      */     public List<Integer> getAleardy_awarded_score_index_listAsData()
/*      */     {
/*  631 */       Role2BackGameInfo.this._xdb_verify_unsafe_();
/*      */       
/*  633 */       Role2BackGameInfo _o_ = Role2BackGameInfo.this;
/*  634 */       List<Integer> aleardy_awarded_score_index_list = new ArrayList();
/*  635 */       aleardy_awarded_score_index_list.addAll(_o_.aleardy_awarded_score_index_list);
/*  636 */       return aleardy_awarded_score_index_list;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getActive_base_value()
/*      */     {
/*  643 */       Role2BackGameInfo.this._xdb_verify_unsafe_();
/*  644 */       return Role2BackGameInfo.this.active_base_value;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getYuan_bao_save_amt_base_value()
/*      */     {
/*  651 */       Role2BackGameInfo.this._xdb_verify_unsafe_();
/*  652 */       return Role2BackGameInfo.this.yuan_bao_save_amt_base_value;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setBack_state_start_time(long _v_)
/*      */     {
/*  659 */       Role2BackGameInfo.this._xdb_verify_unsafe_();
/*  660 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setOffline_days(int _v_)
/*      */     {
/*  667 */       Role2BackGameInfo.this._xdb_verify_unsafe_();
/*  668 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setBack_game_level(int _v_)
/*      */     {
/*  675 */       Role2BackGameInfo.this._xdb_verify_unsafe_();
/*  676 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setClear_score_time(long _v_)
/*      */     {
/*  683 */       Role2BackGameInfo.this._xdb_verify_unsafe_();
/*  684 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setActive_base_value(int _v_)
/*      */     {
/*  691 */       Role2BackGameInfo.this._xdb_verify_unsafe_();
/*  692 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setYuan_bao_save_amt_base_value(long _v_)
/*      */     {
/*  699 */       Role2BackGameInfo.this._xdb_verify_unsafe_();
/*  700 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xdb.Bean toConst()
/*      */     {
/*  706 */       Role2BackGameInfo.this._xdb_verify_unsafe_();
/*  707 */       return this;
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean isConst()
/*      */     {
/*  713 */       Role2BackGameInfo.this._xdb_verify_unsafe_();
/*  714 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean isData()
/*      */     {
/*  720 */       return Role2BackGameInfo.this.isData();
/*      */     }
/*      */     
/*      */ 
/*      */     public OctetsStream marshal(OctetsStream _os_)
/*      */     {
/*  726 */       return Role2BackGameInfo.this.marshal(_os_);
/*      */     }
/*      */     
/*      */     public OctetsStream unmarshal(OctetsStream _os_)
/*      */       throws com.goldhuman.Common.Marshal.MarshalException
/*      */     {
/*  732 */       Role2BackGameInfo.this._xdb_verify_unsafe_();
/*  733 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public int getSerializedSize()
/*      */     {
/*  739 */       return Role2BackGameInfo.this.getSerializedSize();
/*      */     }
/*      */     
/*      */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*  745 */       return Role2BackGameInfo.this.marshal(_output_);
/*      */     }
/*      */     
/*      */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*  751 */       Role2BackGameInfo.this._xdb_verify_unsafe_();
/*  752 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xdb.Bean xdbParent()
/*      */     {
/*  758 */       return Role2BackGameInfo.this.xdbParent();
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean xdbManaged()
/*      */     {
/*  764 */       return Role2BackGameInfo.this.xdbManaged();
/*      */     }
/*      */     
/*      */ 
/*      */     public String xdbVarname()
/*      */     {
/*  770 */       return Role2BackGameInfo.this.xdbVarname();
/*      */     }
/*      */     
/*      */ 
/*      */     public Long xdbObjId()
/*      */     {
/*  776 */       return Role2BackGameInfo.this.xdbObjId();
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean equals(Object obj)
/*      */     {
/*  782 */       return Role2BackGameInfo.this.equals(obj);
/*      */     }
/*      */     
/*      */ 
/*      */     public int hashCode()
/*      */     {
/*  788 */       return Role2BackGameInfo.this.hashCode();
/*      */     }
/*      */     
/*      */ 
/*      */     public String toString()
/*      */     {
/*  794 */       return Role2BackGameInfo.this.toString();
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */   public static final class Data
/*      */     implements xbean.Role2BackGameInfo
/*      */   {
/*      */     private long back_state_start_time;
/*      */     
/*      */     private int offline_days;
/*      */     
/*      */     private int back_game_level;
/*      */     
/*      */     private long clear_score_time;
/*      */     
/*      */     private ArrayList<Integer> aleardy_awarded_score_index_list;
/*      */     
/*      */     private int active_base_value;
/*      */     
/*      */     private long yuan_bao_save_amt_base_value;
/*      */     
/*      */     public void _reset_unsafe_()
/*      */     {
/*  818 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Data()
/*      */     {
/*  823 */       this.aleardy_awarded_score_index_list = new ArrayList();
/*      */     }
/*      */     
/*      */     Data(xbean.Role2BackGameInfo _o1_)
/*      */     {
/*  828 */       if ((_o1_ instanceof Role2BackGameInfo)) { assign((Role2BackGameInfo)_o1_);
/*  829 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  830 */       } else if ((_o1_ instanceof Role2BackGameInfo.Const)) assign(((Role2BackGameInfo.Const)_o1_).nThis()); else {
/*  831 */         throw new UnsupportedOperationException();
/*      */       }
/*      */     }
/*      */     
/*      */     private void assign(Role2BackGameInfo _o_) {
/*  836 */       this.back_state_start_time = _o_.back_state_start_time;
/*  837 */       this.offline_days = _o_.offline_days;
/*  838 */       this.back_game_level = _o_.back_game_level;
/*  839 */       this.clear_score_time = _o_.clear_score_time;
/*  840 */       this.aleardy_awarded_score_index_list = new ArrayList();
/*  841 */       this.aleardy_awarded_score_index_list.addAll(_o_.aleardy_awarded_score_index_list);
/*  842 */       this.active_base_value = _o_.active_base_value;
/*  843 */       this.yuan_bao_save_amt_base_value = _o_.yuan_bao_save_amt_base_value;
/*      */     }
/*      */     
/*      */     private void assign(Data _o_)
/*      */     {
/*  848 */       this.back_state_start_time = _o_.back_state_start_time;
/*  849 */       this.offline_days = _o_.offline_days;
/*  850 */       this.back_game_level = _o_.back_game_level;
/*  851 */       this.clear_score_time = _o_.clear_score_time;
/*  852 */       this.aleardy_awarded_score_index_list = new ArrayList();
/*  853 */       this.aleardy_awarded_score_index_list.addAll(_o_.aleardy_awarded_score_index_list);
/*  854 */       this.active_base_value = _o_.active_base_value;
/*  855 */       this.yuan_bao_save_amt_base_value = _o_.yuan_bao_save_amt_base_value;
/*      */     }
/*      */     
/*      */ 
/*      */     public final OctetsStream marshal(OctetsStream _os_)
/*      */     {
/*  861 */       _os_.marshal(this.back_state_start_time);
/*  862 */       _os_.marshal(this.offline_days);
/*  863 */       _os_.marshal(this.back_game_level);
/*  864 */       _os_.marshal(this.clear_score_time);
/*  865 */       _os_.compact_uint32(this.aleardy_awarded_score_index_list.size());
/*  866 */       for (Integer _v_ : this.aleardy_awarded_score_index_list)
/*      */       {
/*  868 */         _os_.marshal(_v_.intValue());
/*      */       }
/*  870 */       _os_.marshal(this.active_base_value);
/*  871 */       _os_.marshal(this.yuan_bao_save_amt_base_value);
/*  872 */       return _os_;
/*      */     }
/*      */     
/*      */     public final OctetsStream unmarshal(OctetsStream _os_)
/*      */       throws com.goldhuman.Common.Marshal.MarshalException
/*      */     {
/*  878 */       this.back_state_start_time = _os_.unmarshal_long();
/*  879 */       this.offline_days = _os_.unmarshal_int();
/*  880 */       this.back_game_level = _os_.unmarshal_int();
/*  881 */       this.clear_score_time = _os_.unmarshal_long();
/*  882 */       for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*      */       {
/*  884 */         int _v_ = 0;
/*  885 */         _v_ = _os_.unmarshal_int();
/*  886 */         this.aleardy_awarded_score_index_list.add(Integer.valueOf(_v_));
/*      */       }
/*  888 */       this.active_base_value = _os_.unmarshal_int();
/*  889 */       this.yuan_bao_save_amt_base_value = _os_.unmarshal_long();
/*  890 */       return _os_;
/*      */     }
/*      */     
/*      */ 
/*      */     public final int getSerializedSize()
/*      */     {
/*  896 */       int _size_ = 0;
/*  897 */       _size_ += CodedOutputStream.computeInt64Size(1, this.back_state_start_time);
/*  898 */       _size_ += CodedOutputStream.computeInt32Size(2, this.offline_days);
/*  899 */       _size_ += CodedOutputStream.computeInt32Size(3, this.back_game_level);
/*  900 */       _size_ += CodedOutputStream.computeInt64Size(5, this.clear_score_time);
/*  901 */       for (Integer _v_ : this.aleardy_awarded_score_index_list)
/*      */       {
/*  903 */         _size_ += CodedOutputStream.computeInt32Size(6, _v_.intValue());
/*      */       }
/*  905 */       _size_ += CodedOutputStream.computeInt32Size(7, this.active_base_value);
/*  906 */       _size_ += CodedOutputStream.computeInt64Size(8, this.yuan_bao_save_amt_base_value);
/*  907 */       return _size_;
/*      */     }
/*      */     
/*      */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*      */       try
/*      */       {
/*  915 */         _output_.writeInt64(1, this.back_state_start_time);
/*  916 */         _output_.writeInt32(2, this.offline_days);
/*  917 */         _output_.writeInt32(3, this.back_game_level);
/*  918 */         _output_.writeInt64(5, this.clear_score_time);
/*  919 */         for (Integer _v_ : this.aleardy_awarded_score_index_list)
/*      */         {
/*  921 */           _output_.writeInt32(6, _v_.intValue());
/*      */         }
/*  923 */         _output_.writeInt32(7, this.active_base_value);
/*  924 */         _output_.writeInt64(8, this.yuan_bao_save_amt_base_value);
/*      */       }
/*      */       catch (IOException e)
/*      */       {
/*  928 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */       }
/*  930 */       return _output_;
/*      */     }
/*      */     
/*      */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*      */       try
/*      */       {
/*  938 */         boolean done = false;
/*  939 */         while (!done)
/*      */         {
/*  941 */           int tag = _input_.readTag();
/*  942 */           switch (tag)
/*      */           {
/*      */ 
/*      */           case 0: 
/*  946 */             done = true;
/*  947 */             break;
/*      */           
/*      */ 
/*      */           case 8: 
/*  951 */             this.back_state_start_time = _input_.readInt64();
/*  952 */             break;
/*      */           
/*      */ 
/*      */           case 16: 
/*  956 */             this.offline_days = _input_.readInt32();
/*  957 */             break;
/*      */           
/*      */ 
/*      */           case 24: 
/*  961 */             this.back_game_level = _input_.readInt32();
/*  962 */             break;
/*      */           
/*      */ 
/*      */           case 40: 
/*  966 */             this.clear_score_time = _input_.readInt64();
/*  967 */             break;
/*      */           
/*      */ 
/*      */           case 48: 
/*  971 */             int _v_ = 0;
/*  972 */             _v_ = _input_.readInt32();
/*  973 */             this.aleardy_awarded_score_index_list.add(Integer.valueOf(_v_));
/*  974 */             break;
/*      */           
/*      */ 
/*      */           case 56: 
/*  978 */             this.active_base_value = _input_.readInt32();
/*  979 */             break;
/*      */           
/*      */ 
/*      */           case 64: 
/*  983 */             this.yuan_bao_save_amt_base_value = _input_.readInt64();
/*  984 */             break;
/*      */           
/*      */ 
/*      */           default: 
/*  988 */             if (!CodedInputStream.skipUnknownField(tag, _input_))
/*      */             {
/*  990 */               done = true;
/*      */             }
/*      */             break;
/*      */           }
/*      */           
/*      */         }
/*      */       }
/*      */       catch (InvalidProtocolBufferException e)
/*      */       {
/*  999 */         throw e.setUnfinishedMessage(this);
/*      */       }
/*      */       catch (IOException e)
/*      */       {
/* 1003 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */       }
/* 1005 */       return _input_;
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.Role2BackGameInfo copy()
/*      */     {
/* 1011 */       return new Data(this);
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.Role2BackGameInfo toData()
/*      */     {
/* 1017 */       return new Data(this);
/*      */     }
/*      */     
/*      */     public xbean.Role2BackGameInfo toBean()
/*      */     {
/* 1022 */       return new Role2BackGameInfo(this, null, null);
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.Role2BackGameInfo toDataIf()
/*      */     {
/* 1028 */       return this;
/*      */     }
/*      */     
/*      */     public xbean.Role2BackGameInfo toBeanIf()
/*      */     {
/* 1033 */       return new Role2BackGameInfo(this, null, null);
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean xdbManaged()
/*      */     {
/* 1039 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public xdb.Bean xdbParent() {
/* 1043 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public String xdbVarname() {
/* 1047 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Long xdbObjId() {
/* 1051 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public xdb.Bean toConst() {
/* 1055 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public boolean isConst() {
/* 1059 */       return false;
/*      */     }
/*      */     
/*      */     public boolean isData() {
/* 1063 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getBack_state_start_time()
/*      */     {
/* 1070 */       return this.back_state_start_time;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getOffline_days()
/*      */     {
/* 1077 */       return this.offline_days;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getBack_game_level()
/*      */     {
/* 1084 */       return this.back_game_level;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getClear_score_time()
/*      */     {
/* 1091 */       return this.clear_score_time;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public List<Integer> getAleardy_awarded_score_index_list()
/*      */     {
/* 1098 */       return this.aleardy_awarded_score_index_list;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public List<Integer> getAleardy_awarded_score_index_listAsData()
/*      */     {
/* 1105 */       return this.aleardy_awarded_score_index_list;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getActive_base_value()
/*      */     {
/* 1112 */       return this.active_base_value;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getYuan_bao_save_amt_base_value()
/*      */     {
/* 1119 */       return this.yuan_bao_save_amt_base_value;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setBack_state_start_time(long _v_)
/*      */     {
/* 1126 */       this.back_state_start_time = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setOffline_days(int _v_)
/*      */     {
/* 1133 */       this.offline_days = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setBack_game_level(int _v_)
/*      */     {
/* 1140 */       this.back_game_level = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setClear_score_time(long _v_)
/*      */     {
/* 1147 */       this.clear_score_time = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setActive_base_value(int _v_)
/*      */     {
/* 1154 */       this.active_base_value = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setYuan_bao_save_amt_base_value(long _v_)
/*      */     {
/* 1161 */       this.yuan_bao_save_amt_base_value = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */     public final boolean equals(Object _o1_)
/*      */     {
/* 1167 */       if (!(_o1_ instanceof Data)) return false;
/* 1168 */       Data _o_ = (Data)_o1_;
/* 1169 */       if (this.back_state_start_time != _o_.back_state_start_time) return false;
/* 1170 */       if (this.offline_days != _o_.offline_days) return false;
/* 1171 */       if (this.back_game_level != _o_.back_game_level) return false;
/* 1172 */       if (this.clear_score_time != _o_.clear_score_time) return false;
/* 1173 */       if (!this.aleardy_awarded_score_index_list.equals(_o_.aleardy_awarded_score_index_list)) return false;
/* 1174 */       if (this.active_base_value != _o_.active_base_value) return false;
/* 1175 */       if (this.yuan_bao_save_amt_base_value != _o_.yuan_bao_save_amt_base_value) return false;
/* 1176 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */     public final int hashCode()
/*      */     {
/* 1182 */       int _h_ = 0;
/* 1183 */       _h_ = (int)(_h_ + this.back_state_start_time);
/* 1184 */       _h_ += this.offline_days;
/* 1185 */       _h_ += this.back_game_level;
/* 1186 */       _h_ = (int)(_h_ + this.clear_score_time);
/* 1187 */       _h_ += this.aleardy_awarded_score_index_list.hashCode();
/* 1188 */       _h_ += this.active_base_value;
/* 1189 */       _h_ = (int)(_h_ + this.yuan_bao_save_amt_base_value);
/* 1190 */       return _h_;
/*      */     }
/*      */     
/*      */ 
/*      */     public String toString()
/*      */     {
/* 1196 */       StringBuilder _sb_ = new StringBuilder();
/* 1197 */       _sb_.append("(");
/* 1198 */       _sb_.append(this.back_state_start_time);
/* 1199 */       _sb_.append(",");
/* 1200 */       _sb_.append(this.offline_days);
/* 1201 */       _sb_.append(",");
/* 1202 */       _sb_.append(this.back_game_level);
/* 1203 */       _sb_.append(",");
/* 1204 */       _sb_.append(this.clear_score_time);
/* 1205 */       _sb_.append(",");
/* 1206 */       _sb_.append(this.aleardy_awarded_score_index_list);
/* 1207 */       _sb_.append(",");
/* 1208 */       _sb_.append(this.active_base_value);
/* 1209 */       _sb_.append(",");
/* 1210 */       _sb_.append(this.yuan_bao_save_amt_base_value);
/* 1211 */       _sb_.append(")");
/* 1212 */       return _sb_.toString();
/*      */     }
/*      */   }
/*      */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\Role2BackGameInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */