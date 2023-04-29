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
/*      */ 
/*      */ public final class BabyPeriodInfo extends XBean implements xbean.BabyPeriodInfo
/*      */ {
/*      */   private HashMap<Integer, Integer> baby_property_info_map;
/*      */   private int health_score;
/*      */   private long health_refresh_time;
/*      */   private int baby_period_operator;
/*      */   private long baby_period_operator_start_time;
/*      */   private int baby_model_cfg_id;
/*      */   private boolean auto_breed;
/*      */   
/*      */   public void _reset_unsafe_()
/*      */   {
/*   30 */     this.baby_property_info_map.clear();
/*   31 */     this.health_score = 0;
/*   32 */     this.health_refresh_time = 0L;
/*   33 */     this.baby_period_operator = -1;
/*   34 */     this.baby_period_operator_start_time = 0L;
/*   35 */     this.baby_model_cfg_id = 0;
/*   36 */     this.auto_breed = false;
/*      */   }
/*      */   
/*      */   BabyPeriodInfo(int __, XBean _xp_, String _vn_)
/*      */   {
/*   41 */     super(_xp_, _vn_);
/*   42 */     this.baby_property_info_map = new HashMap();
/*   43 */     this.baby_period_operator = -1;
/*   44 */     this.auto_breed = false;
/*      */   }
/*      */   
/*      */   public BabyPeriodInfo()
/*      */   {
/*   49 */     this(0, null, null);
/*      */   }
/*      */   
/*      */   public BabyPeriodInfo(BabyPeriodInfo _o_)
/*      */   {
/*   54 */     this(_o_, null, null);
/*      */   }
/*      */   
/*      */   BabyPeriodInfo(xbean.BabyPeriodInfo _o1_, XBean _xp_, String _vn_)
/*      */   {
/*   59 */     super(_xp_, _vn_);
/*   60 */     if ((_o1_ instanceof BabyPeriodInfo)) { assign((BabyPeriodInfo)_o1_);
/*   61 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*   62 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*   63 */       throw new UnsupportedOperationException();
/*      */     }
/*      */   }
/*      */   
/*      */   private void assign(BabyPeriodInfo _o_) {
/*   68 */     _o_._xdb_verify_unsafe_();
/*   69 */     this.baby_property_info_map = new HashMap();
/*   70 */     for (Map.Entry<Integer, Integer> _e_ : _o_.baby_property_info_map.entrySet())
/*   71 */       this.baby_property_info_map.put(_e_.getKey(), _e_.getValue());
/*   72 */     this.health_score = _o_.health_score;
/*   73 */     this.health_refresh_time = _o_.health_refresh_time;
/*   74 */     this.baby_period_operator = _o_.baby_period_operator;
/*   75 */     this.baby_period_operator_start_time = _o_.baby_period_operator_start_time;
/*   76 */     this.baby_model_cfg_id = _o_.baby_model_cfg_id;
/*   77 */     this.auto_breed = _o_.auto_breed;
/*      */   }
/*      */   
/*      */   private void assign(Data _o_)
/*      */   {
/*   82 */     this.baby_property_info_map = new HashMap();
/*   83 */     for (Map.Entry<Integer, Integer> _e_ : _o_.baby_property_info_map.entrySet())
/*   84 */       this.baby_property_info_map.put(_e_.getKey(), _e_.getValue());
/*   85 */     this.health_score = _o_.health_score;
/*   86 */     this.health_refresh_time = _o_.health_refresh_time;
/*   87 */     this.baby_period_operator = _o_.baby_period_operator;
/*   88 */     this.baby_period_operator_start_time = _o_.baby_period_operator_start_time;
/*   89 */     this.baby_model_cfg_id = _o_.baby_model_cfg_id;
/*   90 */     this.auto_breed = _o_.auto_breed;
/*      */   }
/*      */   
/*      */ 
/*      */   public final OctetsStream marshal(OctetsStream _os_)
/*      */   {
/*   96 */     _xdb_verify_unsafe_();
/*   97 */     _os_.compact_uint32(this.baby_property_info_map.size());
/*   98 */     for (Map.Entry<Integer, Integer> _e_ : this.baby_property_info_map.entrySet())
/*      */     {
/*  100 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/*  101 */       _os_.marshal(((Integer)_e_.getValue()).intValue());
/*      */     }
/*  103 */     _os_.marshal(this.health_score);
/*  104 */     _os_.marshal(this.health_refresh_time);
/*  105 */     _os_.marshal(this.baby_period_operator);
/*  106 */     _os_.marshal(this.baby_period_operator_start_time);
/*  107 */     _os_.marshal(this.baby_model_cfg_id);
/*  108 */     _os_.marshal(this.auto_breed);
/*  109 */     return _os_;
/*      */   }
/*      */   
/*      */   public final OctetsStream unmarshal(OctetsStream _os_)
/*      */     throws com.goldhuman.Common.Marshal.MarshalException
/*      */   {
/*  115 */     _xdb_verify_unsafe_();
/*      */     
/*  117 */     int size = _os_.uncompact_uint32();
/*  118 */     if (size >= 12)
/*      */     {
/*  120 */       this.baby_property_info_map = new HashMap(size * 2);
/*      */     }
/*  122 */     for (; size > 0; size--)
/*      */     {
/*  124 */       int _k_ = 0;
/*  125 */       _k_ = _os_.unmarshal_int();
/*  126 */       int _v_ = 0;
/*  127 */       _v_ = _os_.unmarshal_int();
/*  128 */       this.baby_property_info_map.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*      */     }
/*      */     
/*  131 */     this.health_score = _os_.unmarshal_int();
/*  132 */     this.health_refresh_time = _os_.unmarshal_long();
/*  133 */     this.baby_period_operator = _os_.unmarshal_int();
/*  134 */     this.baby_period_operator_start_time = _os_.unmarshal_long();
/*  135 */     this.baby_model_cfg_id = _os_.unmarshal_int();
/*  136 */     this.auto_breed = _os_.unmarshal_boolean();
/*  137 */     return _os_;
/*      */   }
/*      */   
/*      */ 
/*      */   public int getSerializedSize()
/*      */   {
/*  143 */     _xdb_verify_unsafe_();
/*  144 */     int _size_ = 0;
/*  145 */     for (Map.Entry<Integer, Integer> _e_ : this.baby_property_info_map.entrySet())
/*      */     {
/*  147 */       _size_ += CodedOutputStream.computeInt32Size(1, ((Integer)_e_.getKey()).intValue());
/*  148 */       _size_ += CodedOutputStream.computeInt32Size(1, ((Integer)_e_.getValue()).intValue());
/*      */     }
/*  150 */     _size_ += CodedOutputStream.computeInt32Size(2, this.health_score);
/*  151 */     _size_ += CodedOutputStream.computeInt64Size(3, this.health_refresh_time);
/*  152 */     _size_ += CodedOutputStream.computeInt32Size(4, this.baby_period_operator);
/*  153 */     _size_ += CodedOutputStream.computeInt64Size(5, this.baby_period_operator_start_time);
/*  154 */     _size_ += CodedOutputStream.computeInt32Size(6, this.baby_model_cfg_id);
/*  155 */     _size_ += CodedOutputStream.computeBoolSize(7, this.auto_breed);
/*  156 */     return _size_;
/*      */   }
/*      */   
/*      */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */     throws InvalidProtocolBufferException
/*      */   {
/*  162 */     _xdb_verify_unsafe_();
/*      */     try
/*      */     {
/*  165 */       for (Map.Entry<Integer, Integer> _e_ : this.baby_property_info_map.entrySet())
/*      */       {
/*  167 */         _output_.writeInt32(1, ((Integer)_e_.getKey()).intValue());
/*  168 */         _output_.writeInt32(1, ((Integer)_e_.getValue()).intValue());
/*      */       }
/*  170 */       _output_.writeInt32(2, this.health_score);
/*  171 */       _output_.writeInt64(3, this.health_refresh_time);
/*  172 */       _output_.writeInt32(4, this.baby_period_operator);
/*  173 */       _output_.writeInt64(5, this.baby_period_operator_start_time);
/*  174 */       _output_.writeInt32(6, this.baby_model_cfg_id);
/*  175 */       _output_.writeBool(7, this.auto_breed);
/*      */     }
/*      */     catch (IOException e)
/*      */     {
/*  179 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */     }
/*  181 */     return _output_;
/*      */   }
/*      */   
/*      */   public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */     throws InvalidProtocolBufferException
/*      */   {
/*  187 */     _xdb_verify_unsafe_();
/*      */     try
/*      */     {
/*  190 */       boolean done = false;
/*  191 */       while (!done)
/*      */       {
/*  193 */         int tag = _input_.readTag();
/*  194 */         switch (tag)
/*      */         {
/*      */ 
/*      */         case 0: 
/*  198 */           done = true;
/*  199 */           break;
/*      */         
/*      */ 
/*      */         case 8: 
/*  203 */           int _k_ = 0;
/*  204 */           _k_ = _input_.readInt32();
/*  205 */           int readTag = _input_.readTag();
/*  206 */           if (8 != readTag)
/*      */           {
/*  208 */             throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*      */           }
/*  210 */           int _v_ = 0;
/*  211 */           _v_ = _input_.readInt32();
/*  212 */           this.baby_property_info_map.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*  213 */           break;
/*      */         
/*      */ 
/*      */         case 16: 
/*  217 */           this.health_score = _input_.readInt32();
/*  218 */           break;
/*      */         
/*      */ 
/*      */         case 24: 
/*  222 */           this.health_refresh_time = _input_.readInt64();
/*  223 */           break;
/*      */         
/*      */ 
/*      */         case 32: 
/*  227 */           this.baby_period_operator = _input_.readInt32();
/*  228 */           break;
/*      */         
/*      */ 
/*      */         case 40: 
/*  232 */           this.baby_period_operator_start_time = _input_.readInt64();
/*  233 */           break;
/*      */         
/*      */ 
/*      */         case 48: 
/*  237 */           this.baby_model_cfg_id = _input_.readInt32();
/*  238 */           break;
/*      */         
/*      */ 
/*      */         case 56: 
/*  242 */           this.auto_breed = _input_.readBool();
/*  243 */           break;
/*      */         
/*      */ 
/*      */         default: 
/*  247 */           if (!CodedInputStream.skipUnknownField(tag, _input_))
/*      */           {
/*  249 */             done = true;
/*      */           }
/*      */           break;
/*      */         }
/*      */         
/*      */       }
/*      */     }
/*      */     catch (InvalidProtocolBufferException e)
/*      */     {
/*  258 */       throw e.setUnfinishedMessage(this);
/*      */     }
/*      */     catch (IOException e)
/*      */     {
/*  262 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */     }
/*  264 */     return _input_;
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.BabyPeriodInfo copy()
/*      */   {
/*  270 */     _xdb_verify_unsafe_();
/*  271 */     return new BabyPeriodInfo(this);
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.BabyPeriodInfo toData()
/*      */   {
/*  277 */     _xdb_verify_unsafe_();
/*  278 */     return new Data(this);
/*      */   }
/*      */   
/*      */   public xbean.BabyPeriodInfo toBean()
/*      */   {
/*  283 */     _xdb_verify_unsafe_();
/*  284 */     return new BabyPeriodInfo(this);
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.BabyPeriodInfo toDataIf()
/*      */   {
/*  290 */     _xdb_verify_unsafe_();
/*  291 */     return new Data(this);
/*      */   }
/*      */   
/*      */   public xbean.BabyPeriodInfo toBeanIf()
/*      */   {
/*  296 */     _xdb_verify_unsafe_();
/*  297 */     return this;
/*      */   }
/*      */   
/*      */ 
/*      */   public xdb.Bean toConst()
/*      */   {
/*  303 */     _xdb_verify_unsafe_();
/*  304 */     return new Const(null);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<Integer, Integer> getBaby_property_info_map()
/*      */   {
/*  311 */     _xdb_verify_unsafe_();
/*  312 */     return Logs.logMap(new LogKey(this, "baby_property_info_map"), this.baby_property_info_map);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<Integer, Integer> getBaby_property_info_mapAsData()
/*      */   {
/*  319 */     _xdb_verify_unsafe_();
/*      */     
/*  321 */     BabyPeriodInfo _o_ = this;
/*  322 */     Map<Integer, Integer> baby_property_info_map = new HashMap();
/*  323 */     for (Map.Entry<Integer, Integer> _e_ : _o_.baby_property_info_map.entrySet())
/*  324 */       baby_property_info_map.put(_e_.getKey(), _e_.getValue());
/*  325 */     return baby_property_info_map;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getHealth_score()
/*      */   {
/*  332 */     _xdb_verify_unsafe_();
/*  333 */     return this.health_score;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public long getHealth_refresh_time()
/*      */   {
/*  340 */     _xdb_verify_unsafe_();
/*  341 */     return this.health_refresh_time;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getBaby_period_operator()
/*      */   {
/*  348 */     _xdb_verify_unsafe_();
/*  349 */     return this.baby_period_operator;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public long getBaby_period_operator_start_time()
/*      */   {
/*  356 */     _xdb_verify_unsafe_();
/*  357 */     return this.baby_period_operator_start_time;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getBaby_model_cfg_id()
/*      */   {
/*  364 */     _xdb_verify_unsafe_();
/*  365 */     return this.baby_model_cfg_id;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public boolean getAuto_breed()
/*      */   {
/*  372 */     _xdb_verify_unsafe_();
/*  373 */     return this.auto_breed;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setHealth_score(int _v_)
/*      */   {
/*  380 */     _xdb_verify_unsafe_();
/*  381 */     Logs.logIf(new LogKey(this, "health_score")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  385 */         new xdb.logs.LogInt(this, BabyPeriodInfo.this.health_score)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  389 */             BabyPeriodInfo.this.health_score = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  393 */     });
/*  394 */     this.health_score = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setHealth_refresh_time(long _v_)
/*      */   {
/*  401 */     _xdb_verify_unsafe_();
/*  402 */     Logs.logIf(new LogKey(this, "health_refresh_time")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  406 */         new xdb.logs.LogLong(this, BabyPeriodInfo.this.health_refresh_time)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  410 */             BabyPeriodInfo.this.health_refresh_time = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  414 */     });
/*  415 */     this.health_refresh_time = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setBaby_period_operator(int _v_)
/*      */   {
/*  422 */     _xdb_verify_unsafe_();
/*  423 */     Logs.logIf(new LogKey(this, "baby_period_operator")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  427 */         new xdb.logs.LogInt(this, BabyPeriodInfo.this.baby_period_operator)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  431 */             BabyPeriodInfo.this.baby_period_operator = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  435 */     });
/*  436 */     this.baby_period_operator = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setBaby_period_operator_start_time(long _v_)
/*      */   {
/*  443 */     _xdb_verify_unsafe_();
/*  444 */     Logs.logIf(new LogKey(this, "baby_period_operator_start_time")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  448 */         new xdb.logs.LogLong(this, BabyPeriodInfo.this.baby_period_operator_start_time)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  452 */             BabyPeriodInfo.this.baby_period_operator_start_time = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  456 */     });
/*  457 */     this.baby_period_operator_start_time = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setBaby_model_cfg_id(int _v_)
/*      */   {
/*  464 */     _xdb_verify_unsafe_();
/*  465 */     Logs.logIf(new LogKey(this, "baby_model_cfg_id")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  469 */         new xdb.logs.LogInt(this, BabyPeriodInfo.this.baby_model_cfg_id)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  473 */             BabyPeriodInfo.this.baby_model_cfg_id = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  477 */     });
/*  478 */     this.baby_model_cfg_id = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setAuto_breed(boolean _v_)
/*      */   {
/*  485 */     _xdb_verify_unsafe_();
/*  486 */     Logs.logIf(new LogKey(this, "auto_breed")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  490 */         new xdb.logs.LogObject(this, Boolean.valueOf(BabyPeriodInfo.this.auto_breed))
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  494 */             BabyPeriodInfo.this.auto_breed = ((Boolean)this._xdb_saved).booleanValue();
/*      */           }
/*      */         };
/*      */       }
/*  498 */     });
/*  499 */     this.auto_breed = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */   public final boolean equals(Object _o1_)
/*      */   {
/*  505 */     _xdb_verify_unsafe_();
/*  506 */     BabyPeriodInfo _o_ = null;
/*  507 */     if ((_o1_ instanceof BabyPeriodInfo)) { _o_ = (BabyPeriodInfo)_o1_;
/*  508 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/*  509 */       return false;
/*  510 */     if (!this.baby_property_info_map.equals(_o_.baby_property_info_map)) return false;
/*  511 */     if (this.health_score != _o_.health_score) return false;
/*  512 */     if (this.health_refresh_time != _o_.health_refresh_time) return false;
/*  513 */     if (this.baby_period_operator != _o_.baby_period_operator) return false;
/*  514 */     if (this.baby_period_operator_start_time != _o_.baby_period_operator_start_time) return false;
/*  515 */     if (this.baby_model_cfg_id != _o_.baby_model_cfg_id) return false;
/*  516 */     if (this.auto_breed != _o_.auto_breed) return false;
/*  517 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */   public final int hashCode()
/*      */   {
/*  523 */     _xdb_verify_unsafe_();
/*  524 */     int _h_ = 0;
/*  525 */     _h_ += this.baby_property_info_map.hashCode();
/*  526 */     _h_ += this.health_score;
/*  527 */     _h_ = (int)(_h_ + this.health_refresh_time);
/*  528 */     _h_ += this.baby_period_operator;
/*  529 */     _h_ = (int)(_h_ + this.baby_period_operator_start_time);
/*  530 */     _h_ += this.baby_model_cfg_id;
/*  531 */     _h_ += (this.auto_breed ? 1231 : 1237);
/*  532 */     return _h_;
/*      */   }
/*      */   
/*      */ 
/*      */   public String toString()
/*      */   {
/*  538 */     _xdb_verify_unsafe_();
/*  539 */     StringBuilder _sb_ = new StringBuilder();
/*  540 */     _sb_.append("(");
/*  541 */     _sb_.append(this.baby_property_info_map);
/*  542 */     _sb_.append(",");
/*  543 */     _sb_.append(this.health_score);
/*  544 */     _sb_.append(",");
/*  545 */     _sb_.append(this.health_refresh_time);
/*  546 */     _sb_.append(",");
/*  547 */     _sb_.append(this.baby_period_operator);
/*  548 */     _sb_.append(",");
/*  549 */     _sb_.append(this.baby_period_operator_start_time);
/*  550 */     _sb_.append(",");
/*  551 */     _sb_.append(this.baby_model_cfg_id);
/*  552 */     _sb_.append(",");
/*  553 */     _sb_.append(this.auto_breed);
/*  554 */     _sb_.append(")");
/*  555 */     return _sb_.toString();
/*      */   }
/*      */   
/*      */ 
/*      */   public xdb.logs.Listenable newListenable()
/*      */   {
/*  561 */     ListenableBean lb = new ListenableBean();
/*  562 */     lb.add(new xdb.logs.ListenableMap().setVarName("baby_property_info_map"));
/*  563 */     lb.add(new ListenableChanged().setVarName("health_score"));
/*  564 */     lb.add(new ListenableChanged().setVarName("health_refresh_time"));
/*  565 */     lb.add(new ListenableChanged().setVarName("baby_period_operator"));
/*  566 */     lb.add(new ListenableChanged().setVarName("baby_period_operator_start_time"));
/*  567 */     lb.add(new ListenableChanged().setVarName("baby_model_cfg_id"));
/*  568 */     lb.add(new ListenableChanged().setVarName("auto_breed"));
/*  569 */     return lb;
/*      */   }
/*      */   
/*      */   private class Const implements xbean.BabyPeriodInfo {
/*      */     private Const() {}
/*      */     
/*      */     BabyPeriodInfo nThis() {
/*  576 */       return BabyPeriodInfo.this;
/*      */     }
/*      */     
/*      */ 
/*      */     public void _reset_unsafe_()
/*      */     {
/*  582 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.BabyPeriodInfo copy()
/*      */     {
/*  588 */       return BabyPeriodInfo.this.copy();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.BabyPeriodInfo toData()
/*      */     {
/*  594 */       return BabyPeriodInfo.this.toData();
/*      */     }
/*      */     
/*      */     public xbean.BabyPeriodInfo toBean()
/*      */     {
/*  599 */       return BabyPeriodInfo.this.toBean();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.BabyPeriodInfo toDataIf()
/*      */     {
/*  605 */       return BabyPeriodInfo.this.toDataIf();
/*      */     }
/*      */     
/*      */     public xbean.BabyPeriodInfo toBeanIf()
/*      */     {
/*  610 */       return BabyPeriodInfo.this.toBeanIf();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, Integer> getBaby_property_info_map()
/*      */     {
/*  617 */       BabyPeriodInfo.this._xdb_verify_unsafe_();
/*  618 */       return xdb.Consts.constMap(BabyPeriodInfo.this.baby_property_info_map);
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, Integer> getBaby_property_info_mapAsData()
/*      */     {
/*  625 */       BabyPeriodInfo.this._xdb_verify_unsafe_();
/*      */       
/*  627 */       BabyPeriodInfo _o_ = BabyPeriodInfo.this;
/*  628 */       Map<Integer, Integer> baby_property_info_map = new HashMap();
/*  629 */       for (Map.Entry<Integer, Integer> _e_ : _o_.baby_property_info_map.entrySet())
/*  630 */         baby_property_info_map.put(_e_.getKey(), _e_.getValue());
/*  631 */       return baby_property_info_map;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getHealth_score()
/*      */     {
/*  638 */       BabyPeriodInfo.this._xdb_verify_unsafe_();
/*  639 */       return BabyPeriodInfo.this.health_score;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getHealth_refresh_time()
/*      */     {
/*  646 */       BabyPeriodInfo.this._xdb_verify_unsafe_();
/*  647 */       return BabyPeriodInfo.this.health_refresh_time;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getBaby_period_operator()
/*      */     {
/*  654 */       BabyPeriodInfo.this._xdb_verify_unsafe_();
/*  655 */       return BabyPeriodInfo.this.baby_period_operator;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getBaby_period_operator_start_time()
/*      */     {
/*  662 */       BabyPeriodInfo.this._xdb_verify_unsafe_();
/*  663 */       return BabyPeriodInfo.this.baby_period_operator_start_time;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getBaby_model_cfg_id()
/*      */     {
/*  670 */       BabyPeriodInfo.this._xdb_verify_unsafe_();
/*  671 */       return BabyPeriodInfo.this.baby_model_cfg_id;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public boolean getAuto_breed()
/*      */     {
/*  678 */       BabyPeriodInfo.this._xdb_verify_unsafe_();
/*  679 */       return BabyPeriodInfo.this.auto_breed;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setHealth_score(int _v_)
/*      */     {
/*  686 */       BabyPeriodInfo.this._xdb_verify_unsafe_();
/*  687 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setHealth_refresh_time(long _v_)
/*      */     {
/*  694 */       BabyPeriodInfo.this._xdb_verify_unsafe_();
/*  695 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setBaby_period_operator(int _v_)
/*      */     {
/*  702 */       BabyPeriodInfo.this._xdb_verify_unsafe_();
/*  703 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setBaby_period_operator_start_time(long _v_)
/*      */     {
/*  710 */       BabyPeriodInfo.this._xdb_verify_unsafe_();
/*  711 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setBaby_model_cfg_id(int _v_)
/*      */     {
/*  718 */       BabyPeriodInfo.this._xdb_verify_unsafe_();
/*  719 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setAuto_breed(boolean _v_)
/*      */     {
/*  726 */       BabyPeriodInfo.this._xdb_verify_unsafe_();
/*  727 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xdb.Bean toConst()
/*      */     {
/*  733 */       BabyPeriodInfo.this._xdb_verify_unsafe_();
/*  734 */       return this;
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean isConst()
/*      */     {
/*  740 */       BabyPeriodInfo.this._xdb_verify_unsafe_();
/*  741 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean isData()
/*      */     {
/*  747 */       return BabyPeriodInfo.this.isData();
/*      */     }
/*      */     
/*      */ 
/*      */     public OctetsStream marshal(OctetsStream _os_)
/*      */     {
/*  753 */       return BabyPeriodInfo.this.marshal(_os_);
/*      */     }
/*      */     
/*      */     public OctetsStream unmarshal(OctetsStream _os_)
/*      */       throws com.goldhuman.Common.Marshal.MarshalException
/*      */     {
/*  759 */       BabyPeriodInfo.this._xdb_verify_unsafe_();
/*  760 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public int getSerializedSize()
/*      */     {
/*  766 */       return BabyPeriodInfo.this.getSerializedSize();
/*      */     }
/*      */     
/*      */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*  772 */       return BabyPeriodInfo.this.marshal(_output_);
/*      */     }
/*      */     
/*      */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*  778 */       BabyPeriodInfo.this._xdb_verify_unsafe_();
/*  779 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xdb.Bean xdbParent()
/*      */     {
/*  785 */       return BabyPeriodInfo.this.xdbParent();
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean xdbManaged()
/*      */     {
/*  791 */       return BabyPeriodInfo.this.xdbManaged();
/*      */     }
/*      */     
/*      */ 
/*      */     public String xdbVarname()
/*      */     {
/*  797 */       return BabyPeriodInfo.this.xdbVarname();
/*      */     }
/*      */     
/*      */ 
/*      */     public Long xdbObjId()
/*      */     {
/*  803 */       return BabyPeriodInfo.this.xdbObjId();
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean equals(Object obj)
/*      */     {
/*  809 */       return BabyPeriodInfo.this.equals(obj);
/*      */     }
/*      */     
/*      */ 
/*      */     public int hashCode()
/*      */     {
/*  815 */       return BabyPeriodInfo.this.hashCode();
/*      */     }
/*      */     
/*      */ 
/*      */     public String toString()
/*      */     {
/*  821 */       return BabyPeriodInfo.this.toString();
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */   public static final class Data
/*      */     implements xbean.BabyPeriodInfo
/*      */   {
/*      */     private HashMap<Integer, Integer> baby_property_info_map;
/*      */     
/*      */     private int health_score;
/*      */     
/*      */     private long health_refresh_time;
/*      */     
/*      */     private int baby_period_operator;
/*      */     
/*      */     private long baby_period_operator_start_time;
/*      */     
/*      */     private int baby_model_cfg_id;
/*      */     
/*      */     private boolean auto_breed;
/*      */     
/*      */     public void _reset_unsafe_()
/*      */     {
/*  845 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Data()
/*      */     {
/*  850 */       this.baby_property_info_map = new HashMap();
/*  851 */       this.baby_period_operator = -1;
/*  852 */       this.auto_breed = false;
/*      */     }
/*      */     
/*      */     Data(xbean.BabyPeriodInfo _o1_)
/*      */     {
/*  857 */       if ((_o1_ instanceof BabyPeriodInfo)) { assign((BabyPeriodInfo)_o1_);
/*  858 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  859 */       } else if ((_o1_ instanceof BabyPeriodInfo.Const)) assign(((BabyPeriodInfo.Const)_o1_).nThis()); else {
/*  860 */         throw new UnsupportedOperationException();
/*      */       }
/*      */     }
/*      */     
/*      */     private void assign(BabyPeriodInfo _o_) {
/*  865 */       this.baby_property_info_map = new HashMap();
/*  866 */       for (Map.Entry<Integer, Integer> _e_ : _o_.baby_property_info_map.entrySet())
/*  867 */         this.baby_property_info_map.put(_e_.getKey(), _e_.getValue());
/*  868 */       this.health_score = _o_.health_score;
/*  869 */       this.health_refresh_time = _o_.health_refresh_time;
/*  870 */       this.baby_period_operator = _o_.baby_period_operator;
/*  871 */       this.baby_period_operator_start_time = _o_.baby_period_operator_start_time;
/*  872 */       this.baby_model_cfg_id = _o_.baby_model_cfg_id;
/*  873 */       this.auto_breed = _o_.auto_breed;
/*      */     }
/*      */     
/*      */     private void assign(Data _o_)
/*      */     {
/*  878 */       this.baby_property_info_map = new HashMap();
/*  879 */       for (Map.Entry<Integer, Integer> _e_ : _o_.baby_property_info_map.entrySet())
/*  880 */         this.baby_property_info_map.put(_e_.getKey(), _e_.getValue());
/*  881 */       this.health_score = _o_.health_score;
/*  882 */       this.health_refresh_time = _o_.health_refresh_time;
/*  883 */       this.baby_period_operator = _o_.baby_period_operator;
/*  884 */       this.baby_period_operator_start_time = _o_.baby_period_operator_start_time;
/*  885 */       this.baby_model_cfg_id = _o_.baby_model_cfg_id;
/*  886 */       this.auto_breed = _o_.auto_breed;
/*      */     }
/*      */     
/*      */ 
/*      */     public final OctetsStream marshal(OctetsStream _os_)
/*      */     {
/*  892 */       _os_.compact_uint32(this.baby_property_info_map.size());
/*  893 */       for (Map.Entry<Integer, Integer> _e_ : this.baby_property_info_map.entrySet())
/*      */       {
/*  895 */         _os_.marshal(((Integer)_e_.getKey()).intValue());
/*  896 */         _os_.marshal(((Integer)_e_.getValue()).intValue());
/*      */       }
/*  898 */       _os_.marshal(this.health_score);
/*  899 */       _os_.marshal(this.health_refresh_time);
/*  900 */       _os_.marshal(this.baby_period_operator);
/*  901 */       _os_.marshal(this.baby_period_operator_start_time);
/*  902 */       _os_.marshal(this.baby_model_cfg_id);
/*  903 */       _os_.marshal(this.auto_breed);
/*  904 */       return _os_;
/*      */     }
/*      */     
/*      */ 
/*      */     public final OctetsStream unmarshal(OctetsStream _os_)
/*      */       throws com.goldhuman.Common.Marshal.MarshalException
/*      */     {
/*  911 */       int size = _os_.uncompact_uint32();
/*  912 */       if (size >= 12)
/*      */       {
/*  914 */         this.baby_property_info_map = new HashMap(size * 2);
/*      */       }
/*  916 */       for (; size > 0; size--)
/*      */       {
/*  918 */         int _k_ = 0;
/*  919 */         _k_ = _os_.unmarshal_int();
/*  920 */         int _v_ = 0;
/*  921 */         _v_ = _os_.unmarshal_int();
/*  922 */         this.baby_property_info_map.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*      */       }
/*      */       
/*  925 */       this.health_score = _os_.unmarshal_int();
/*  926 */       this.health_refresh_time = _os_.unmarshal_long();
/*  927 */       this.baby_period_operator = _os_.unmarshal_int();
/*  928 */       this.baby_period_operator_start_time = _os_.unmarshal_long();
/*  929 */       this.baby_model_cfg_id = _os_.unmarshal_int();
/*  930 */       this.auto_breed = _os_.unmarshal_boolean();
/*  931 */       return _os_;
/*      */     }
/*      */     
/*      */ 
/*      */     public final int getSerializedSize()
/*      */     {
/*  937 */       int _size_ = 0;
/*  938 */       for (Map.Entry<Integer, Integer> _e_ : this.baby_property_info_map.entrySet())
/*      */       {
/*  940 */         _size_ += CodedOutputStream.computeInt32Size(1, ((Integer)_e_.getKey()).intValue());
/*  941 */         _size_ += CodedOutputStream.computeInt32Size(1, ((Integer)_e_.getValue()).intValue());
/*      */       }
/*  943 */       _size_ += CodedOutputStream.computeInt32Size(2, this.health_score);
/*  944 */       _size_ += CodedOutputStream.computeInt64Size(3, this.health_refresh_time);
/*  945 */       _size_ += CodedOutputStream.computeInt32Size(4, this.baby_period_operator);
/*  946 */       _size_ += CodedOutputStream.computeInt64Size(5, this.baby_period_operator_start_time);
/*  947 */       _size_ += CodedOutputStream.computeInt32Size(6, this.baby_model_cfg_id);
/*  948 */       _size_ += CodedOutputStream.computeBoolSize(7, this.auto_breed);
/*  949 */       return _size_;
/*      */     }
/*      */     
/*      */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*      */       try
/*      */       {
/*  957 */         for (Map.Entry<Integer, Integer> _e_ : this.baby_property_info_map.entrySet())
/*      */         {
/*  959 */           _output_.writeInt32(1, ((Integer)_e_.getKey()).intValue());
/*  960 */           _output_.writeInt32(1, ((Integer)_e_.getValue()).intValue());
/*      */         }
/*  962 */         _output_.writeInt32(2, this.health_score);
/*  963 */         _output_.writeInt64(3, this.health_refresh_time);
/*  964 */         _output_.writeInt32(4, this.baby_period_operator);
/*  965 */         _output_.writeInt64(5, this.baby_period_operator_start_time);
/*  966 */         _output_.writeInt32(6, this.baby_model_cfg_id);
/*  967 */         _output_.writeBool(7, this.auto_breed);
/*      */       }
/*      */       catch (IOException e)
/*      */       {
/*  971 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */       }
/*  973 */       return _output_;
/*      */     }
/*      */     
/*      */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*      */       try
/*      */       {
/*  981 */         boolean done = false;
/*  982 */         while (!done)
/*      */         {
/*  984 */           int tag = _input_.readTag();
/*  985 */           switch (tag)
/*      */           {
/*      */ 
/*      */           case 0: 
/*  989 */             done = true;
/*  990 */             break;
/*      */           
/*      */ 
/*      */           case 8: 
/*  994 */             int _k_ = 0;
/*  995 */             _k_ = _input_.readInt32();
/*  996 */             int readTag = _input_.readTag();
/*  997 */             if (8 != readTag)
/*      */             {
/*  999 */               throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*      */             }
/* 1001 */             int _v_ = 0;
/* 1002 */             _v_ = _input_.readInt32();
/* 1003 */             this.baby_property_info_map.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/* 1004 */             break;
/*      */           
/*      */ 
/*      */           case 16: 
/* 1008 */             this.health_score = _input_.readInt32();
/* 1009 */             break;
/*      */           
/*      */ 
/*      */           case 24: 
/* 1013 */             this.health_refresh_time = _input_.readInt64();
/* 1014 */             break;
/*      */           
/*      */ 
/*      */           case 32: 
/* 1018 */             this.baby_period_operator = _input_.readInt32();
/* 1019 */             break;
/*      */           
/*      */ 
/*      */           case 40: 
/* 1023 */             this.baby_period_operator_start_time = _input_.readInt64();
/* 1024 */             break;
/*      */           
/*      */ 
/*      */           case 48: 
/* 1028 */             this.baby_model_cfg_id = _input_.readInt32();
/* 1029 */             break;
/*      */           
/*      */ 
/*      */           case 56: 
/* 1033 */             this.auto_breed = _input_.readBool();
/* 1034 */             break;
/*      */           
/*      */ 
/*      */           default: 
/* 1038 */             if (!CodedInputStream.skipUnknownField(tag, _input_))
/*      */             {
/* 1040 */               done = true;
/*      */             }
/*      */             break;
/*      */           }
/*      */           
/*      */         }
/*      */       }
/*      */       catch (InvalidProtocolBufferException e)
/*      */       {
/* 1049 */         throw e.setUnfinishedMessage(this);
/*      */       }
/*      */       catch (IOException e)
/*      */       {
/* 1053 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */       }
/* 1055 */       return _input_;
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.BabyPeriodInfo copy()
/*      */     {
/* 1061 */       return new Data(this);
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.BabyPeriodInfo toData()
/*      */     {
/* 1067 */       return new Data(this);
/*      */     }
/*      */     
/*      */     public xbean.BabyPeriodInfo toBean()
/*      */     {
/* 1072 */       return new BabyPeriodInfo(this, null, null);
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.BabyPeriodInfo toDataIf()
/*      */     {
/* 1078 */       return this;
/*      */     }
/*      */     
/*      */     public xbean.BabyPeriodInfo toBeanIf()
/*      */     {
/* 1083 */       return new BabyPeriodInfo(this, null, null);
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean xdbManaged()
/*      */     {
/* 1089 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public xdb.Bean xdbParent() {
/* 1093 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public String xdbVarname() {
/* 1097 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Long xdbObjId() {
/* 1101 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public xdb.Bean toConst() {
/* 1105 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public boolean isConst() {
/* 1109 */       return false;
/*      */     }
/*      */     
/*      */     public boolean isData() {
/* 1113 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, Integer> getBaby_property_info_map()
/*      */     {
/* 1120 */       return this.baby_property_info_map;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, Integer> getBaby_property_info_mapAsData()
/*      */     {
/* 1127 */       return this.baby_property_info_map;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getHealth_score()
/*      */     {
/* 1134 */       return this.health_score;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getHealth_refresh_time()
/*      */     {
/* 1141 */       return this.health_refresh_time;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getBaby_period_operator()
/*      */     {
/* 1148 */       return this.baby_period_operator;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getBaby_period_operator_start_time()
/*      */     {
/* 1155 */       return this.baby_period_operator_start_time;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getBaby_model_cfg_id()
/*      */     {
/* 1162 */       return this.baby_model_cfg_id;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public boolean getAuto_breed()
/*      */     {
/* 1169 */       return this.auto_breed;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setHealth_score(int _v_)
/*      */     {
/* 1176 */       this.health_score = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setHealth_refresh_time(long _v_)
/*      */     {
/* 1183 */       this.health_refresh_time = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setBaby_period_operator(int _v_)
/*      */     {
/* 1190 */       this.baby_period_operator = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setBaby_period_operator_start_time(long _v_)
/*      */     {
/* 1197 */       this.baby_period_operator_start_time = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setBaby_model_cfg_id(int _v_)
/*      */     {
/* 1204 */       this.baby_model_cfg_id = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setAuto_breed(boolean _v_)
/*      */     {
/* 1211 */       this.auto_breed = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */     public final boolean equals(Object _o1_)
/*      */     {
/* 1217 */       if (!(_o1_ instanceof Data)) return false;
/* 1218 */       Data _o_ = (Data)_o1_;
/* 1219 */       if (!this.baby_property_info_map.equals(_o_.baby_property_info_map)) return false;
/* 1220 */       if (this.health_score != _o_.health_score) return false;
/* 1221 */       if (this.health_refresh_time != _o_.health_refresh_time) return false;
/* 1222 */       if (this.baby_period_operator != _o_.baby_period_operator) return false;
/* 1223 */       if (this.baby_period_operator_start_time != _o_.baby_period_operator_start_time) return false;
/* 1224 */       if (this.baby_model_cfg_id != _o_.baby_model_cfg_id) return false;
/* 1225 */       if (this.auto_breed != _o_.auto_breed) return false;
/* 1226 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */     public final int hashCode()
/*      */     {
/* 1232 */       int _h_ = 0;
/* 1233 */       _h_ += this.baby_property_info_map.hashCode();
/* 1234 */       _h_ += this.health_score;
/* 1235 */       _h_ = (int)(_h_ + this.health_refresh_time);
/* 1236 */       _h_ += this.baby_period_operator;
/* 1237 */       _h_ = (int)(_h_ + this.baby_period_operator_start_time);
/* 1238 */       _h_ += this.baby_model_cfg_id;
/* 1239 */       _h_ += (this.auto_breed ? 1231 : 1237);
/* 1240 */       return _h_;
/*      */     }
/*      */     
/*      */ 
/*      */     public String toString()
/*      */     {
/* 1246 */       StringBuilder _sb_ = new StringBuilder();
/* 1247 */       _sb_.append("(");
/* 1248 */       _sb_.append(this.baby_property_info_map);
/* 1249 */       _sb_.append(",");
/* 1250 */       _sb_.append(this.health_score);
/* 1251 */       _sb_.append(",");
/* 1252 */       _sb_.append(this.health_refresh_time);
/* 1253 */       _sb_.append(",");
/* 1254 */       _sb_.append(this.baby_period_operator);
/* 1255 */       _sb_.append(",");
/* 1256 */       _sb_.append(this.baby_period_operator_start_time);
/* 1257 */       _sb_.append(",");
/* 1258 */       _sb_.append(this.baby_model_cfg_id);
/* 1259 */       _sb_.append(",");
/* 1260 */       _sb_.append(this.auto_breed);
/* 1261 */       _sb_.append(")");
/* 1262 */       return _sb_.toString();
/*      */     }
/*      */   }
/*      */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\BabyPeriodInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */