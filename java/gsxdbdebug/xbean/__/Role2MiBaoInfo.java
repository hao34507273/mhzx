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
/*      */ import xdb.Log;
/*      */ import xdb.LogKey;
/*      */ import xdb.Logs;
/*      */ import xdb.XBean;
/*      */ import xdb.logs.ListenableBean;
/*      */ import xdb.logs.ListenableChanged;
/*      */ import xdb.logs.LogInt;
/*      */ 
/*      */ public final class Role2MiBaoInfo extends XBean implements xbean.Role2MiBaoInfo
/*      */ {
/*      */   private int buy_times_today;
/*      */   private int current_score;
/*      */   private int current_lucky_value;
/*      */   private int current_index_id;
/*      */   private long should_exchange_score_limit_end_time;
/*      */   private long should_exchange_score_limit_begin_time;
/*      */   private boolean is_exchange_score;
/*      */   private HashMap<Integer, Integer> limit_item_draw_times_map;
/*      */   
/*      */   public void _reset_unsafe_()
/*      */   {
/*   32 */     this.buy_times_today = 0;
/*   33 */     this.current_score = 0;
/*   34 */     this.current_lucky_value = 0;
/*   35 */     this.current_index_id = 0;
/*   36 */     this.should_exchange_score_limit_end_time = 0L;
/*   37 */     this.should_exchange_score_limit_begin_time = 0L;
/*   38 */     this.is_exchange_score = false;
/*   39 */     this.limit_item_draw_times_map.clear();
/*      */   }
/*      */   
/*      */   Role2MiBaoInfo(int __, XBean _xp_, String _vn_)
/*      */   {
/*   44 */     super(_xp_, _vn_);
/*   45 */     this.limit_item_draw_times_map = new HashMap();
/*      */   }
/*      */   
/*      */   public Role2MiBaoInfo()
/*      */   {
/*   50 */     this(0, null, null);
/*      */   }
/*      */   
/*      */   public Role2MiBaoInfo(Role2MiBaoInfo _o_)
/*      */   {
/*   55 */     this(_o_, null, null);
/*      */   }
/*      */   
/*      */   Role2MiBaoInfo(xbean.Role2MiBaoInfo _o1_, XBean _xp_, String _vn_)
/*      */   {
/*   60 */     super(_xp_, _vn_);
/*   61 */     if ((_o1_ instanceof Role2MiBaoInfo)) { assign((Role2MiBaoInfo)_o1_);
/*   62 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*   63 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*   64 */       throw new UnsupportedOperationException();
/*      */     }
/*      */   }
/*      */   
/*      */   private void assign(Role2MiBaoInfo _o_) {
/*   69 */     _o_._xdb_verify_unsafe_();
/*   70 */     this.buy_times_today = _o_.buy_times_today;
/*   71 */     this.current_score = _o_.current_score;
/*   72 */     this.current_lucky_value = _o_.current_lucky_value;
/*   73 */     this.current_index_id = _o_.current_index_id;
/*   74 */     this.should_exchange_score_limit_end_time = _o_.should_exchange_score_limit_end_time;
/*   75 */     this.should_exchange_score_limit_begin_time = _o_.should_exchange_score_limit_begin_time;
/*   76 */     this.is_exchange_score = _o_.is_exchange_score;
/*   77 */     this.limit_item_draw_times_map = new HashMap();
/*   78 */     for (Map.Entry<Integer, Integer> _e_ : _o_.limit_item_draw_times_map.entrySet()) {
/*   79 */       this.limit_item_draw_times_map.put(_e_.getKey(), _e_.getValue());
/*      */     }
/*      */   }
/*      */   
/*      */   private void assign(Data _o_) {
/*   84 */     this.buy_times_today = _o_.buy_times_today;
/*   85 */     this.current_score = _o_.current_score;
/*   86 */     this.current_lucky_value = _o_.current_lucky_value;
/*   87 */     this.current_index_id = _o_.current_index_id;
/*   88 */     this.should_exchange_score_limit_end_time = _o_.should_exchange_score_limit_end_time;
/*   89 */     this.should_exchange_score_limit_begin_time = _o_.should_exchange_score_limit_begin_time;
/*   90 */     this.is_exchange_score = _o_.is_exchange_score;
/*   91 */     this.limit_item_draw_times_map = new HashMap();
/*   92 */     for (Map.Entry<Integer, Integer> _e_ : _o_.limit_item_draw_times_map.entrySet()) {
/*   93 */       this.limit_item_draw_times_map.put(_e_.getKey(), _e_.getValue());
/*      */     }
/*      */   }
/*      */   
/*      */   public final OctetsStream marshal(OctetsStream _os_)
/*      */   {
/*   99 */     _xdb_verify_unsafe_();
/*  100 */     _os_.marshal(this.buy_times_today);
/*  101 */     _os_.marshal(this.current_score);
/*  102 */     _os_.marshal(this.current_lucky_value);
/*  103 */     _os_.marshal(this.current_index_id);
/*  104 */     _os_.marshal(this.should_exchange_score_limit_end_time);
/*  105 */     _os_.marshal(this.should_exchange_score_limit_begin_time);
/*  106 */     _os_.marshal(this.is_exchange_score);
/*  107 */     _os_.compact_uint32(this.limit_item_draw_times_map.size());
/*  108 */     for (Map.Entry<Integer, Integer> _e_ : this.limit_item_draw_times_map.entrySet())
/*      */     {
/*  110 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/*  111 */       _os_.marshal(((Integer)_e_.getValue()).intValue());
/*      */     }
/*  113 */     return _os_;
/*      */   }
/*      */   
/*      */   public final OctetsStream unmarshal(OctetsStream _os_)
/*      */     throws com.goldhuman.Common.Marshal.MarshalException
/*      */   {
/*  119 */     _xdb_verify_unsafe_();
/*  120 */     this.buy_times_today = _os_.unmarshal_int();
/*  121 */     this.current_score = _os_.unmarshal_int();
/*  122 */     this.current_lucky_value = _os_.unmarshal_int();
/*  123 */     this.current_index_id = _os_.unmarshal_int();
/*  124 */     this.should_exchange_score_limit_end_time = _os_.unmarshal_long();
/*  125 */     this.should_exchange_score_limit_begin_time = _os_.unmarshal_long();
/*  126 */     this.is_exchange_score = _os_.unmarshal_boolean();
/*      */     
/*  128 */     int size = _os_.uncompact_uint32();
/*  129 */     if (size >= 12)
/*      */     {
/*  131 */       this.limit_item_draw_times_map = new HashMap(size * 2);
/*      */     }
/*  133 */     for (; size > 0; size--)
/*      */     {
/*  135 */       int _k_ = 0;
/*  136 */       _k_ = _os_.unmarshal_int();
/*  137 */       int _v_ = 0;
/*  138 */       _v_ = _os_.unmarshal_int();
/*  139 */       this.limit_item_draw_times_map.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*      */     }
/*      */     
/*  142 */     return _os_;
/*      */   }
/*      */   
/*      */ 
/*      */   public int getSerializedSize()
/*      */   {
/*  148 */     _xdb_verify_unsafe_();
/*  149 */     int _size_ = 0;
/*  150 */     _size_ += CodedOutputStream.computeInt32Size(1, this.buy_times_today);
/*  151 */     _size_ += CodedOutputStream.computeInt32Size(2, this.current_score);
/*  152 */     _size_ += CodedOutputStream.computeInt32Size(3, this.current_lucky_value);
/*  153 */     _size_ += CodedOutputStream.computeInt32Size(4, this.current_index_id);
/*  154 */     _size_ += CodedOutputStream.computeInt64Size(5, this.should_exchange_score_limit_end_time);
/*  155 */     _size_ += CodedOutputStream.computeInt64Size(6, this.should_exchange_score_limit_begin_time);
/*  156 */     _size_ += CodedOutputStream.computeBoolSize(7, this.is_exchange_score);
/*  157 */     for (Map.Entry<Integer, Integer> _e_ : this.limit_item_draw_times_map.entrySet())
/*      */     {
/*  159 */       _size_ += CodedOutputStream.computeInt32Size(8, ((Integer)_e_.getKey()).intValue());
/*  160 */       _size_ += CodedOutputStream.computeInt32Size(8, ((Integer)_e_.getValue()).intValue());
/*      */     }
/*  162 */     return _size_;
/*      */   }
/*      */   
/*      */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */     throws InvalidProtocolBufferException
/*      */   {
/*  168 */     _xdb_verify_unsafe_();
/*      */     try
/*      */     {
/*  171 */       _output_.writeInt32(1, this.buy_times_today);
/*  172 */       _output_.writeInt32(2, this.current_score);
/*  173 */       _output_.writeInt32(3, this.current_lucky_value);
/*  174 */       _output_.writeInt32(4, this.current_index_id);
/*  175 */       _output_.writeInt64(5, this.should_exchange_score_limit_end_time);
/*  176 */       _output_.writeInt64(6, this.should_exchange_score_limit_begin_time);
/*  177 */       _output_.writeBool(7, this.is_exchange_score);
/*  178 */       for (Map.Entry<Integer, Integer> _e_ : this.limit_item_draw_times_map.entrySet())
/*      */       {
/*  180 */         _output_.writeInt32(8, ((Integer)_e_.getKey()).intValue());
/*  181 */         _output_.writeInt32(8, ((Integer)_e_.getValue()).intValue());
/*      */       }
/*      */     }
/*      */     catch (IOException e)
/*      */     {
/*  186 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */     }
/*  188 */     return _output_;
/*      */   }
/*      */   
/*      */   public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */     throws InvalidProtocolBufferException
/*      */   {
/*  194 */     _xdb_verify_unsafe_();
/*      */     try
/*      */     {
/*  197 */       boolean done = false;
/*  198 */       while (!done)
/*      */       {
/*  200 */         int tag = _input_.readTag();
/*  201 */         switch (tag)
/*      */         {
/*      */ 
/*      */         case 0: 
/*  205 */           done = true;
/*  206 */           break;
/*      */         
/*      */ 
/*      */         case 8: 
/*  210 */           this.buy_times_today = _input_.readInt32();
/*  211 */           break;
/*      */         
/*      */ 
/*      */         case 16: 
/*  215 */           this.current_score = _input_.readInt32();
/*  216 */           break;
/*      */         
/*      */ 
/*      */         case 24: 
/*  220 */           this.current_lucky_value = _input_.readInt32();
/*  221 */           break;
/*      */         
/*      */ 
/*      */         case 32: 
/*  225 */           this.current_index_id = _input_.readInt32();
/*  226 */           break;
/*      */         
/*      */ 
/*      */         case 40: 
/*  230 */           this.should_exchange_score_limit_end_time = _input_.readInt64();
/*  231 */           break;
/*      */         
/*      */ 
/*      */         case 48: 
/*  235 */           this.should_exchange_score_limit_begin_time = _input_.readInt64();
/*  236 */           break;
/*      */         
/*      */ 
/*      */         case 56: 
/*  240 */           this.is_exchange_score = _input_.readBool();
/*  241 */           break;
/*      */         
/*      */ 
/*      */         case 64: 
/*  245 */           int _k_ = 0;
/*  246 */           _k_ = _input_.readInt32();
/*  247 */           int readTag = _input_.readTag();
/*  248 */           if (64 != readTag)
/*      */           {
/*  250 */             throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*      */           }
/*  252 */           int _v_ = 0;
/*  253 */           _v_ = _input_.readInt32();
/*  254 */           this.limit_item_draw_times_map.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*  255 */           break;
/*      */         
/*      */ 
/*      */         default: 
/*  259 */           if (!CodedInputStream.skipUnknownField(tag, _input_))
/*      */           {
/*  261 */             done = true;
/*      */           }
/*      */           break;
/*      */         }
/*      */         
/*      */       }
/*      */     }
/*      */     catch (InvalidProtocolBufferException e)
/*      */     {
/*  270 */       throw e.setUnfinishedMessage(this);
/*      */     }
/*      */     catch (IOException e)
/*      */     {
/*  274 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */     }
/*  276 */     return _input_;
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.Role2MiBaoInfo copy()
/*      */   {
/*  282 */     _xdb_verify_unsafe_();
/*  283 */     return new Role2MiBaoInfo(this);
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.Role2MiBaoInfo toData()
/*      */   {
/*  289 */     _xdb_verify_unsafe_();
/*  290 */     return new Data(this);
/*      */   }
/*      */   
/*      */   public xbean.Role2MiBaoInfo toBean()
/*      */   {
/*  295 */     _xdb_verify_unsafe_();
/*  296 */     return new Role2MiBaoInfo(this);
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.Role2MiBaoInfo toDataIf()
/*      */   {
/*  302 */     _xdb_verify_unsafe_();
/*  303 */     return new Data(this);
/*      */   }
/*      */   
/*      */   public xbean.Role2MiBaoInfo toBeanIf()
/*      */   {
/*  308 */     _xdb_verify_unsafe_();
/*  309 */     return this;
/*      */   }
/*      */   
/*      */ 
/*      */   public xdb.Bean toConst()
/*      */   {
/*  315 */     _xdb_verify_unsafe_();
/*  316 */     return new Const(null);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getBuy_times_today()
/*      */   {
/*  323 */     _xdb_verify_unsafe_();
/*  324 */     return this.buy_times_today;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getCurrent_score()
/*      */   {
/*  331 */     _xdb_verify_unsafe_();
/*  332 */     return this.current_score;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getCurrent_lucky_value()
/*      */   {
/*  339 */     _xdb_verify_unsafe_();
/*  340 */     return this.current_lucky_value;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getCurrent_index_id()
/*      */   {
/*  347 */     _xdb_verify_unsafe_();
/*  348 */     return this.current_index_id;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public long getShould_exchange_score_limit_end_time()
/*      */   {
/*  355 */     _xdb_verify_unsafe_();
/*  356 */     return this.should_exchange_score_limit_end_time;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public long getShould_exchange_score_limit_begin_time()
/*      */   {
/*  363 */     _xdb_verify_unsafe_();
/*  364 */     return this.should_exchange_score_limit_begin_time;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public boolean getIs_exchange_score()
/*      */   {
/*  371 */     _xdb_verify_unsafe_();
/*  372 */     return this.is_exchange_score;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<Integer, Integer> getLimit_item_draw_times_map()
/*      */   {
/*  379 */     _xdb_verify_unsafe_();
/*  380 */     return Logs.logMap(new LogKey(this, "limit_item_draw_times_map"), this.limit_item_draw_times_map);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<Integer, Integer> getLimit_item_draw_times_mapAsData()
/*      */   {
/*  387 */     _xdb_verify_unsafe_();
/*      */     
/*  389 */     Role2MiBaoInfo _o_ = this;
/*  390 */     Map<Integer, Integer> limit_item_draw_times_map = new HashMap();
/*  391 */     for (Map.Entry<Integer, Integer> _e_ : _o_.limit_item_draw_times_map.entrySet())
/*  392 */       limit_item_draw_times_map.put(_e_.getKey(), _e_.getValue());
/*  393 */     return limit_item_draw_times_map;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setBuy_times_today(int _v_)
/*      */   {
/*  400 */     _xdb_verify_unsafe_();
/*  401 */     Logs.logIf(new LogKey(this, "buy_times_today")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  405 */         new LogInt(this, Role2MiBaoInfo.this.buy_times_today)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  409 */             Role2MiBaoInfo.this.buy_times_today = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  413 */     });
/*  414 */     this.buy_times_today = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setCurrent_score(int _v_)
/*      */   {
/*  421 */     _xdb_verify_unsafe_();
/*  422 */     Logs.logIf(new LogKey(this, "current_score")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  426 */         new LogInt(this, Role2MiBaoInfo.this.current_score)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  430 */             Role2MiBaoInfo.this.current_score = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  434 */     });
/*  435 */     this.current_score = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setCurrent_lucky_value(int _v_)
/*      */   {
/*  442 */     _xdb_verify_unsafe_();
/*  443 */     Logs.logIf(new LogKey(this, "current_lucky_value")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  447 */         new LogInt(this, Role2MiBaoInfo.this.current_lucky_value)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  451 */             Role2MiBaoInfo.this.current_lucky_value = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  455 */     });
/*  456 */     this.current_lucky_value = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setCurrent_index_id(int _v_)
/*      */   {
/*  463 */     _xdb_verify_unsafe_();
/*  464 */     Logs.logIf(new LogKey(this, "current_index_id")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  468 */         new LogInt(this, Role2MiBaoInfo.this.current_index_id)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  472 */             Role2MiBaoInfo.this.current_index_id = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  476 */     });
/*  477 */     this.current_index_id = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setShould_exchange_score_limit_end_time(long _v_)
/*      */   {
/*  484 */     _xdb_verify_unsafe_();
/*  485 */     Logs.logIf(new LogKey(this, "should_exchange_score_limit_end_time")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  489 */         new xdb.logs.LogLong(this, Role2MiBaoInfo.this.should_exchange_score_limit_end_time)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  493 */             Role2MiBaoInfo.this.should_exchange_score_limit_end_time = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  497 */     });
/*  498 */     this.should_exchange_score_limit_end_time = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setShould_exchange_score_limit_begin_time(long _v_)
/*      */   {
/*  505 */     _xdb_verify_unsafe_();
/*  506 */     Logs.logIf(new LogKey(this, "should_exchange_score_limit_begin_time")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  510 */         new xdb.logs.LogLong(this, Role2MiBaoInfo.this.should_exchange_score_limit_begin_time)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  514 */             Role2MiBaoInfo.this.should_exchange_score_limit_begin_time = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  518 */     });
/*  519 */     this.should_exchange_score_limit_begin_time = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setIs_exchange_score(boolean _v_)
/*      */   {
/*  526 */     _xdb_verify_unsafe_();
/*  527 */     Logs.logIf(new LogKey(this, "is_exchange_score")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  531 */         new xdb.logs.LogObject(this, Boolean.valueOf(Role2MiBaoInfo.this.is_exchange_score))
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  535 */             Role2MiBaoInfo.this.is_exchange_score = ((Boolean)this._xdb_saved).booleanValue();
/*      */           }
/*      */         };
/*      */       }
/*  539 */     });
/*  540 */     this.is_exchange_score = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */   public final boolean equals(Object _o1_)
/*      */   {
/*  546 */     _xdb_verify_unsafe_();
/*  547 */     Role2MiBaoInfo _o_ = null;
/*  548 */     if ((_o1_ instanceof Role2MiBaoInfo)) { _o_ = (Role2MiBaoInfo)_o1_;
/*  549 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/*  550 */       return false;
/*  551 */     if (this.buy_times_today != _o_.buy_times_today) return false;
/*  552 */     if (this.current_score != _o_.current_score) return false;
/*  553 */     if (this.current_lucky_value != _o_.current_lucky_value) return false;
/*  554 */     if (this.current_index_id != _o_.current_index_id) return false;
/*  555 */     if (this.should_exchange_score_limit_end_time != _o_.should_exchange_score_limit_end_time) return false;
/*  556 */     if (this.should_exchange_score_limit_begin_time != _o_.should_exchange_score_limit_begin_time) return false;
/*  557 */     if (this.is_exchange_score != _o_.is_exchange_score) return false;
/*  558 */     if (!this.limit_item_draw_times_map.equals(_o_.limit_item_draw_times_map)) return false;
/*  559 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */   public final int hashCode()
/*      */   {
/*  565 */     _xdb_verify_unsafe_();
/*  566 */     int _h_ = 0;
/*  567 */     _h_ += this.buy_times_today;
/*  568 */     _h_ += this.current_score;
/*  569 */     _h_ += this.current_lucky_value;
/*  570 */     _h_ += this.current_index_id;
/*  571 */     _h_ = (int)(_h_ + this.should_exchange_score_limit_end_time);
/*  572 */     _h_ = (int)(_h_ + this.should_exchange_score_limit_begin_time);
/*  573 */     _h_ += (this.is_exchange_score ? 1231 : 1237);
/*  574 */     _h_ += this.limit_item_draw_times_map.hashCode();
/*  575 */     return _h_;
/*      */   }
/*      */   
/*      */ 
/*      */   public String toString()
/*      */   {
/*  581 */     _xdb_verify_unsafe_();
/*  582 */     StringBuilder _sb_ = new StringBuilder();
/*  583 */     _sb_.append("(");
/*  584 */     _sb_.append(this.buy_times_today);
/*  585 */     _sb_.append(",");
/*  586 */     _sb_.append(this.current_score);
/*  587 */     _sb_.append(",");
/*  588 */     _sb_.append(this.current_lucky_value);
/*  589 */     _sb_.append(",");
/*  590 */     _sb_.append(this.current_index_id);
/*  591 */     _sb_.append(",");
/*  592 */     _sb_.append(this.should_exchange_score_limit_end_time);
/*  593 */     _sb_.append(",");
/*  594 */     _sb_.append(this.should_exchange_score_limit_begin_time);
/*  595 */     _sb_.append(",");
/*  596 */     _sb_.append(this.is_exchange_score);
/*  597 */     _sb_.append(",");
/*  598 */     _sb_.append(this.limit_item_draw_times_map);
/*  599 */     _sb_.append(")");
/*  600 */     return _sb_.toString();
/*      */   }
/*      */   
/*      */ 
/*      */   public xdb.logs.Listenable newListenable()
/*      */   {
/*  606 */     ListenableBean lb = new ListenableBean();
/*  607 */     lb.add(new ListenableChanged().setVarName("buy_times_today"));
/*  608 */     lb.add(new ListenableChanged().setVarName("current_score"));
/*  609 */     lb.add(new ListenableChanged().setVarName("current_lucky_value"));
/*  610 */     lb.add(new ListenableChanged().setVarName("current_index_id"));
/*  611 */     lb.add(new ListenableChanged().setVarName("should_exchange_score_limit_end_time"));
/*  612 */     lb.add(new ListenableChanged().setVarName("should_exchange_score_limit_begin_time"));
/*  613 */     lb.add(new ListenableChanged().setVarName("is_exchange_score"));
/*  614 */     lb.add(new xdb.logs.ListenableMap().setVarName("limit_item_draw_times_map"));
/*  615 */     return lb;
/*      */   }
/*      */   
/*      */   private class Const implements xbean.Role2MiBaoInfo {
/*      */     private Const() {}
/*      */     
/*      */     Role2MiBaoInfo nThis() {
/*  622 */       return Role2MiBaoInfo.this;
/*      */     }
/*      */     
/*      */ 
/*      */     public void _reset_unsafe_()
/*      */     {
/*  628 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.Role2MiBaoInfo copy()
/*      */     {
/*  634 */       return Role2MiBaoInfo.this.copy();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.Role2MiBaoInfo toData()
/*      */     {
/*  640 */       return Role2MiBaoInfo.this.toData();
/*      */     }
/*      */     
/*      */     public xbean.Role2MiBaoInfo toBean()
/*      */     {
/*  645 */       return Role2MiBaoInfo.this.toBean();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.Role2MiBaoInfo toDataIf()
/*      */     {
/*  651 */       return Role2MiBaoInfo.this.toDataIf();
/*      */     }
/*      */     
/*      */     public xbean.Role2MiBaoInfo toBeanIf()
/*      */     {
/*  656 */       return Role2MiBaoInfo.this.toBeanIf();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getBuy_times_today()
/*      */     {
/*  663 */       Role2MiBaoInfo.this._xdb_verify_unsafe_();
/*  664 */       return Role2MiBaoInfo.this.buy_times_today;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getCurrent_score()
/*      */     {
/*  671 */       Role2MiBaoInfo.this._xdb_verify_unsafe_();
/*  672 */       return Role2MiBaoInfo.this.current_score;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getCurrent_lucky_value()
/*      */     {
/*  679 */       Role2MiBaoInfo.this._xdb_verify_unsafe_();
/*  680 */       return Role2MiBaoInfo.this.current_lucky_value;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getCurrent_index_id()
/*      */     {
/*  687 */       Role2MiBaoInfo.this._xdb_verify_unsafe_();
/*  688 */       return Role2MiBaoInfo.this.current_index_id;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getShould_exchange_score_limit_end_time()
/*      */     {
/*  695 */       Role2MiBaoInfo.this._xdb_verify_unsafe_();
/*  696 */       return Role2MiBaoInfo.this.should_exchange_score_limit_end_time;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getShould_exchange_score_limit_begin_time()
/*      */     {
/*  703 */       Role2MiBaoInfo.this._xdb_verify_unsafe_();
/*  704 */       return Role2MiBaoInfo.this.should_exchange_score_limit_begin_time;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public boolean getIs_exchange_score()
/*      */     {
/*  711 */       Role2MiBaoInfo.this._xdb_verify_unsafe_();
/*  712 */       return Role2MiBaoInfo.this.is_exchange_score;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, Integer> getLimit_item_draw_times_map()
/*      */     {
/*  719 */       Role2MiBaoInfo.this._xdb_verify_unsafe_();
/*  720 */       return xdb.Consts.constMap(Role2MiBaoInfo.this.limit_item_draw_times_map);
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, Integer> getLimit_item_draw_times_mapAsData()
/*      */     {
/*  727 */       Role2MiBaoInfo.this._xdb_verify_unsafe_();
/*      */       
/*  729 */       Role2MiBaoInfo _o_ = Role2MiBaoInfo.this;
/*  730 */       Map<Integer, Integer> limit_item_draw_times_map = new HashMap();
/*  731 */       for (Map.Entry<Integer, Integer> _e_ : _o_.limit_item_draw_times_map.entrySet())
/*  732 */         limit_item_draw_times_map.put(_e_.getKey(), _e_.getValue());
/*  733 */       return limit_item_draw_times_map;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setBuy_times_today(int _v_)
/*      */     {
/*  740 */       Role2MiBaoInfo.this._xdb_verify_unsafe_();
/*  741 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setCurrent_score(int _v_)
/*      */     {
/*  748 */       Role2MiBaoInfo.this._xdb_verify_unsafe_();
/*  749 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setCurrent_lucky_value(int _v_)
/*      */     {
/*  756 */       Role2MiBaoInfo.this._xdb_verify_unsafe_();
/*  757 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setCurrent_index_id(int _v_)
/*      */     {
/*  764 */       Role2MiBaoInfo.this._xdb_verify_unsafe_();
/*  765 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setShould_exchange_score_limit_end_time(long _v_)
/*      */     {
/*  772 */       Role2MiBaoInfo.this._xdb_verify_unsafe_();
/*  773 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setShould_exchange_score_limit_begin_time(long _v_)
/*      */     {
/*  780 */       Role2MiBaoInfo.this._xdb_verify_unsafe_();
/*  781 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setIs_exchange_score(boolean _v_)
/*      */     {
/*  788 */       Role2MiBaoInfo.this._xdb_verify_unsafe_();
/*  789 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xdb.Bean toConst()
/*      */     {
/*  795 */       Role2MiBaoInfo.this._xdb_verify_unsafe_();
/*  796 */       return this;
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean isConst()
/*      */     {
/*  802 */       Role2MiBaoInfo.this._xdb_verify_unsafe_();
/*  803 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean isData()
/*      */     {
/*  809 */       return Role2MiBaoInfo.this.isData();
/*      */     }
/*      */     
/*      */ 
/*      */     public OctetsStream marshal(OctetsStream _os_)
/*      */     {
/*  815 */       return Role2MiBaoInfo.this.marshal(_os_);
/*      */     }
/*      */     
/*      */     public OctetsStream unmarshal(OctetsStream _os_)
/*      */       throws com.goldhuman.Common.Marshal.MarshalException
/*      */     {
/*  821 */       Role2MiBaoInfo.this._xdb_verify_unsafe_();
/*  822 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public int getSerializedSize()
/*      */     {
/*  828 */       return Role2MiBaoInfo.this.getSerializedSize();
/*      */     }
/*      */     
/*      */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*  834 */       return Role2MiBaoInfo.this.marshal(_output_);
/*      */     }
/*      */     
/*      */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*  840 */       Role2MiBaoInfo.this._xdb_verify_unsafe_();
/*  841 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xdb.Bean xdbParent()
/*      */     {
/*  847 */       return Role2MiBaoInfo.this.xdbParent();
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean xdbManaged()
/*      */     {
/*  853 */       return Role2MiBaoInfo.this.xdbManaged();
/*      */     }
/*      */     
/*      */ 
/*      */     public String xdbVarname()
/*      */     {
/*  859 */       return Role2MiBaoInfo.this.xdbVarname();
/*      */     }
/*      */     
/*      */ 
/*      */     public Long xdbObjId()
/*      */     {
/*  865 */       return Role2MiBaoInfo.this.xdbObjId();
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean equals(Object obj)
/*      */     {
/*  871 */       return Role2MiBaoInfo.this.equals(obj);
/*      */     }
/*      */     
/*      */ 
/*      */     public int hashCode()
/*      */     {
/*  877 */       return Role2MiBaoInfo.this.hashCode();
/*      */     }
/*      */     
/*      */ 
/*      */     public String toString()
/*      */     {
/*  883 */       return Role2MiBaoInfo.this.toString();
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */   public static final class Data
/*      */     implements xbean.Role2MiBaoInfo
/*      */   {
/*      */     private int buy_times_today;
/*      */     
/*      */     private int current_score;
/*      */     
/*      */     private int current_lucky_value;
/*      */     
/*      */     private int current_index_id;
/*      */     
/*      */     private long should_exchange_score_limit_end_time;
/*      */     
/*      */     private long should_exchange_score_limit_begin_time;
/*      */     
/*      */     private boolean is_exchange_score;
/*      */     
/*      */     private HashMap<Integer, Integer> limit_item_draw_times_map;
/*      */     
/*      */     public void _reset_unsafe_()
/*      */     {
/*  909 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Data()
/*      */     {
/*  914 */       this.limit_item_draw_times_map = new HashMap();
/*      */     }
/*      */     
/*      */     Data(xbean.Role2MiBaoInfo _o1_)
/*      */     {
/*  919 */       if ((_o1_ instanceof Role2MiBaoInfo)) { assign((Role2MiBaoInfo)_o1_);
/*  920 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  921 */       } else if ((_o1_ instanceof Role2MiBaoInfo.Const)) assign(((Role2MiBaoInfo.Const)_o1_).nThis()); else {
/*  922 */         throw new UnsupportedOperationException();
/*      */       }
/*      */     }
/*      */     
/*      */     private void assign(Role2MiBaoInfo _o_) {
/*  927 */       this.buy_times_today = _o_.buy_times_today;
/*  928 */       this.current_score = _o_.current_score;
/*  929 */       this.current_lucky_value = _o_.current_lucky_value;
/*  930 */       this.current_index_id = _o_.current_index_id;
/*  931 */       this.should_exchange_score_limit_end_time = _o_.should_exchange_score_limit_end_time;
/*  932 */       this.should_exchange_score_limit_begin_time = _o_.should_exchange_score_limit_begin_time;
/*  933 */       this.is_exchange_score = _o_.is_exchange_score;
/*  934 */       this.limit_item_draw_times_map = new HashMap();
/*  935 */       for (Map.Entry<Integer, Integer> _e_ : _o_.limit_item_draw_times_map.entrySet()) {
/*  936 */         this.limit_item_draw_times_map.put(_e_.getKey(), _e_.getValue());
/*      */       }
/*      */     }
/*      */     
/*      */     private void assign(Data _o_) {
/*  941 */       this.buy_times_today = _o_.buy_times_today;
/*  942 */       this.current_score = _o_.current_score;
/*  943 */       this.current_lucky_value = _o_.current_lucky_value;
/*  944 */       this.current_index_id = _o_.current_index_id;
/*  945 */       this.should_exchange_score_limit_end_time = _o_.should_exchange_score_limit_end_time;
/*  946 */       this.should_exchange_score_limit_begin_time = _o_.should_exchange_score_limit_begin_time;
/*  947 */       this.is_exchange_score = _o_.is_exchange_score;
/*  948 */       this.limit_item_draw_times_map = new HashMap();
/*  949 */       for (Map.Entry<Integer, Integer> _e_ : _o_.limit_item_draw_times_map.entrySet()) {
/*  950 */         this.limit_item_draw_times_map.put(_e_.getKey(), _e_.getValue());
/*      */       }
/*      */     }
/*      */     
/*      */     public final OctetsStream marshal(OctetsStream _os_)
/*      */     {
/*  956 */       _os_.marshal(this.buy_times_today);
/*  957 */       _os_.marshal(this.current_score);
/*  958 */       _os_.marshal(this.current_lucky_value);
/*  959 */       _os_.marshal(this.current_index_id);
/*  960 */       _os_.marshal(this.should_exchange_score_limit_end_time);
/*  961 */       _os_.marshal(this.should_exchange_score_limit_begin_time);
/*  962 */       _os_.marshal(this.is_exchange_score);
/*  963 */       _os_.compact_uint32(this.limit_item_draw_times_map.size());
/*  964 */       for (Map.Entry<Integer, Integer> _e_ : this.limit_item_draw_times_map.entrySet())
/*      */       {
/*  966 */         _os_.marshal(((Integer)_e_.getKey()).intValue());
/*  967 */         _os_.marshal(((Integer)_e_.getValue()).intValue());
/*      */       }
/*  969 */       return _os_;
/*      */     }
/*      */     
/*      */     public final OctetsStream unmarshal(OctetsStream _os_)
/*      */       throws com.goldhuman.Common.Marshal.MarshalException
/*      */     {
/*  975 */       this.buy_times_today = _os_.unmarshal_int();
/*  976 */       this.current_score = _os_.unmarshal_int();
/*  977 */       this.current_lucky_value = _os_.unmarshal_int();
/*  978 */       this.current_index_id = _os_.unmarshal_int();
/*  979 */       this.should_exchange_score_limit_end_time = _os_.unmarshal_long();
/*  980 */       this.should_exchange_score_limit_begin_time = _os_.unmarshal_long();
/*  981 */       this.is_exchange_score = _os_.unmarshal_boolean();
/*      */       
/*  983 */       int size = _os_.uncompact_uint32();
/*  984 */       if (size >= 12)
/*      */       {
/*  986 */         this.limit_item_draw_times_map = new HashMap(size * 2);
/*      */       }
/*  988 */       for (; size > 0; size--)
/*      */       {
/*  990 */         int _k_ = 0;
/*  991 */         _k_ = _os_.unmarshal_int();
/*  992 */         int _v_ = 0;
/*  993 */         _v_ = _os_.unmarshal_int();
/*  994 */         this.limit_item_draw_times_map.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*      */       }
/*      */       
/*  997 */       return _os_;
/*      */     }
/*      */     
/*      */ 
/*      */     public final int getSerializedSize()
/*      */     {
/* 1003 */       int _size_ = 0;
/* 1004 */       _size_ += CodedOutputStream.computeInt32Size(1, this.buy_times_today);
/* 1005 */       _size_ += CodedOutputStream.computeInt32Size(2, this.current_score);
/* 1006 */       _size_ += CodedOutputStream.computeInt32Size(3, this.current_lucky_value);
/* 1007 */       _size_ += CodedOutputStream.computeInt32Size(4, this.current_index_id);
/* 1008 */       _size_ += CodedOutputStream.computeInt64Size(5, this.should_exchange_score_limit_end_time);
/* 1009 */       _size_ += CodedOutputStream.computeInt64Size(6, this.should_exchange_score_limit_begin_time);
/* 1010 */       _size_ += CodedOutputStream.computeBoolSize(7, this.is_exchange_score);
/* 1011 */       for (Map.Entry<Integer, Integer> _e_ : this.limit_item_draw_times_map.entrySet())
/*      */       {
/* 1013 */         _size_ += CodedOutputStream.computeInt32Size(8, ((Integer)_e_.getKey()).intValue());
/* 1014 */         _size_ += CodedOutputStream.computeInt32Size(8, ((Integer)_e_.getValue()).intValue());
/*      */       }
/* 1016 */       return _size_;
/*      */     }
/*      */     
/*      */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*      */       try
/*      */       {
/* 1024 */         _output_.writeInt32(1, this.buy_times_today);
/* 1025 */         _output_.writeInt32(2, this.current_score);
/* 1026 */         _output_.writeInt32(3, this.current_lucky_value);
/* 1027 */         _output_.writeInt32(4, this.current_index_id);
/* 1028 */         _output_.writeInt64(5, this.should_exchange_score_limit_end_time);
/* 1029 */         _output_.writeInt64(6, this.should_exchange_score_limit_begin_time);
/* 1030 */         _output_.writeBool(7, this.is_exchange_score);
/* 1031 */         for (Map.Entry<Integer, Integer> _e_ : this.limit_item_draw_times_map.entrySet())
/*      */         {
/* 1033 */           _output_.writeInt32(8, ((Integer)_e_.getKey()).intValue());
/* 1034 */           _output_.writeInt32(8, ((Integer)_e_.getValue()).intValue());
/*      */         }
/*      */       }
/*      */       catch (IOException e)
/*      */       {
/* 1039 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */       }
/* 1041 */       return _output_;
/*      */     }
/*      */     
/*      */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*      */       try
/*      */       {
/* 1049 */         boolean done = false;
/* 1050 */         while (!done)
/*      */         {
/* 1052 */           int tag = _input_.readTag();
/* 1053 */           switch (tag)
/*      */           {
/*      */ 
/*      */           case 0: 
/* 1057 */             done = true;
/* 1058 */             break;
/*      */           
/*      */ 
/*      */           case 8: 
/* 1062 */             this.buy_times_today = _input_.readInt32();
/* 1063 */             break;
/*      */           
/*      */ 
/*      */           case 16: 
/* 1067 */             this.current_score = _input_.readInt32();
/* 1068 */             break;
/*      */           
/*      */ 
/*      */           case 24: 
/* 1072 */             this.current_lucky_value = _input_.readInt32();
/* 1073 */             break;
/*      */           
/*      */ 
/*      */           case 32: 
/* 1077 */             this.current_index_id = _input_.readInt32();
/* 1078 */             break;
/*      */           
/*      */ 
/*      */           case 40: 
/* 1082 */             this.should_exchange_score_limit_end_time = _input_.readInt64();
/* 1083 */             break;
/*      */           
/*      */ 
/*      */           case 48: 
/* 1087 */             this.should_exchange_score_limit_begin_time = _input_.readInt64();
/* 1088 */             break;
/*      */           
/*      */ 
/*      */           case 56: 
/* 1092 */             this.is_exchange_score = _input_.readBool();
/* 1093 */             break;
/*      */           
/*      */ 
/*      */           case 64: 
/* 1097 */             int _k_ = 0;
/* 1098 */             _k_ = _input_.readInt32();
/* 1099 */             int readTag = _input_.readTag();
/* 1100 */             if (64 != readTag)
/*      */             {
/* 1102 */               throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*      */             }
/* 1104 */             int _v_ = 0;
/* 1105 */             _v_ = _input_.readInt32();
/* 1106 */             this.limit_item_draw_times_map.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/* 1107 */             break;
/*      */           
/*      */ 
/*      */           default: 
/* 1111 */             if (!CodedInputStream.skipUnknownField(tag, _input_))
/*      */             {
/* 1113 */               done = true;
/*      */             }
/*      */             break;
/*      */           }
/*      */           
/*      */         }
/*      */       }
/*      */       catch (InvalidProtocolBufferException e)
/*      */       {
/* 1122 */         throw e.setUnfinishedMessage(this);
/*      */       }
/*      */       catch (IOException e)
/*      */       {
/* 1126 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */       }
/* 1128 */       return _input_;
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.Role2MiBaoInfo copy()
/*      */     {
/* 1134 */       return new Data(this);
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.Role2MiBaoInfo toData()
/*      */     {
/* 1140 */       return new Data(this);
/*      */     }
/*      */     
/*      */     public xbean.Role2MiBaoInfo toBean()
/*      */     {
/* 1145 */       return new Role2MiBaoInfo(this, null, null);
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.Role2MiBaoInfo toDataIf()
/*      */     {
/* 1151 */       return this;
/*      */     }
/*      */     
/*      */     public xbean.Role2MiBaoInfo toBeanIf()
/*      */     {
/* 1156 */       return new Role2MiBaoInfo(this, null, null);
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean xdbManaged()
/*      */     {
/* 1162 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public xdb.Bean xdbParent() {
/* 1166 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public String xdbVarname() {
/* 1170 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Long xdbObjId() {
/* 1174 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public xdb.Bean toConst() {
/* 1178 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public boolean isConst() {
/* 1182 */       return false;
/*      */     }
/*      */     
/*      */     public boolean isData() {
/* 1186 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getBuy_times_today()
/*      */     {
/* 1193 */       return this.buy_times_today;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getCurrent_score()
/*      */     {
/* 1200 */       return this.current_score;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getCurrent_lucky_value()
/*      */     {
/* 1207 */       return this.current_lucky_value;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getCurrent_index_id()
/*      */     {
/* 1214 */       return this.current_index_id;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getShould_exchange_score_limit_end_time()
/*      */     {
/* 1221 */       return this.should_exchange_score_limit_end_time;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getShould_exchange_score_limit_begin_time()
/*      */     {
/* 1228 */       return this.should_exchange_score_limit_begin_time;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public boolean getIs_exchange_score()
/*      */     {
/* 1235 */       return this.is_exchange_score;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, Integer> getLimit_item_draw_times_map()
/*      */     {
/* 1242 */       return this.limit_item_draw_times_map;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, Integer> getLimit_item_draw_times_mapAsData()
/*      */     {
/* 1249 */       return this.limit_item_draw_times_map;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setBuy_times_today(int _v_)
/*      */     {
/* 1256 */       this.buy_times_today = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setCurrent_score(int _v_)
/*      */     {
/* 1263 */       this.current_score = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setCurrent_lucky_value(int _v_)
/*      */     {
/* 1270 */       this.current_lucky_value = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setCurrent_index_id(int _v_)
/*      */     {
/* 1277 */       this.current_index_id = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setShould_exchange_score_limit_end_time(long _v_)
/*      */     {
/* 1284 */       this.should_exchange_score_limit_end_time = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setShould_exchange_score_limit_begin_time(long _v_)
/*      */     {
/* 1291 */       this.should_exchange_score_limit_begin_time = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setIs_exchange_score(boolean _v_)
/*      */     {
/* 1298 */       this.is_exchange_score = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */     public final boolean equals(Object _o1_)
/*      */     {
/* 1304 */       if (!(_o1_ instanceof Data)) return false;
/* 1305 */       Data _o_ = (Data)_o1_;
/* 1306 */       if (this.buy_times_today != _o_.buy_times_today) return false;
/* 1307 */       if (this.current_score != _o_.current_score) return false;
/* 1308 */       if (this.current_lucky_value != _o_.current_lucky_value) return false;
/* 1309 */       if (this.current_index_id != _o_.current_index_id) return false;
/* 1310 */       if (this.should_exchange_score_limit_end_time != _o_.should_exchange_score_limit_end_time) return false;
/* 1311 */       if (this.should_exchange_score_limit_begin_time != _o_.should_exchange_score_limit_begin_time) return false;
/* 1312 */       if (this.is_exchange_score != _o_.is_exchange_score) return false;
/* 1313 */       if (!this.limit_item_draw_times_map.equals(_o_.limit_item_draw_times_map)) return false;
/* 1314 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */     public final int hashCode()
/*      */     {
/* 1320 */       int _h_ = 0;
/* 1321 */       _h_ += this.buy_times_today;
/* 1322 */       _h_ += this.current_score;
/* 1323 */       _h_ += this.current_lucky_value;
/* 1324 */       _h_ += this.current_index_id;
/* 1325 */       _h_ = (int)(_h_ + this.should_exchange_score_limit_end_time);
/* 1326 */       _h_ = (int)(_h_ + this.should_exchange_score_limit_begin_time);
/* 1327 */       _h_ += (this.is_exchange_score ? 1231 : 1237);
/* 1328 */       _h_ += this.limit_item_draw_times_map.hashCode();
/* 1329 */       return _h_;
/*      */     }
/*      */     
/*      */ 
/*      */     public String toString()
/*      */     {
/* 1335 */       StringBuilder _sb_ = new StringBuilder();
/* 1336 */       _sb_.append("(");
/* 1337 */       _sb_.append(this.buy_times_today);
/* 1338 */       _sb_.append(",");
/* 1339 */       _sb_.append(this.current_score);
/* 1340 */       _sb_.append(",");
/* 1341 */       _sb_.append(this.current_lucky_value);
/* 1342 */       _sb_.append(",");
/* 1343 */       _sb_.append(this.current_index_id);
/* 1344 */       _sb_.append(",");
/* 1345 */       _sb_.append(this.should_exchange_score_limit_end_time);
/* 1346 */       _sb_.append(",");
/* 1347 */       _sb_.append(this.should_exchange_score_limit_begin_time);
/* 1348 */       _sb_.append(",");
/* 1349 */       _sb_.append(this.is_exchange_score);
/* 1350 */       _sb_.append(",");
/* 1351 */       _sb_.append(this.limit_item_draw_times_map);
/* 1352 */       _sb_.append(")");
/* 1353 */       return _sb_.toString();
/*      */     }
/*      */   }
/*      */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\Role2MiBaoInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */