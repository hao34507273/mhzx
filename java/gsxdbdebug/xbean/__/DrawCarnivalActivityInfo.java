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
/*      */ 
/*      */ public final class DrawCarnivalActivityInfo extends XBean implements xbean.DrawCarnivalActivityInfo
/*      */ {
/*      */   private xbean.DrawCarnivalAwardWinnerInfo last_winner_role_info;
/*      */   private long accumulate_yuan_bao_cost_count;
/*      */   private HashMap<Integer, Integer> pass_type_id2extra_rate_per_pass;
/*      */   private int big_award_count;
/*      */   private HashMap<Integer, Integer> random_type_id2chest_count;
/*      */   
/*      */   public void _reset_unsafe_()
/*      */   {
/*   26 */     this.last_winner_role_info._reset_unsafe_();
/*   27 */     this.accumulate_yuan_bao_cost_count = 0L;
/*   28 */     this.pass_type_id2extra_rate_per_pass.clear();
/*   29 */     this.big_award_count = 0;
/*   30 */     this.random_type_id2chest_count.clear();
/*      */   }
/*      */   
/*      */   DrawCarnivalActivityInfo(int __, XBean _xp_, String _vn_)
/*      */   {
/*   35 */     super(_xp_, _vn_);
/*   36 */     this.last_winner_role_info = new DrawCarnivalAwardWinnerInfo(0, this, "last_winner_role_info");
/*   37 */     this.pass_type_id2extra_rate_per_pass = new HashMap();
/*   38 */     this.random_type_id2chest_count = new HashMap();
/*      */   }
/*      */   
/*      */   public DrawCarnivalActivityInfo()
/*      */   {
/*   43 */     this(0, null, null);
/*      */   }
/*      */   
/*      */   public DrawCarnivalActivityInfo(DrawCarnivalActivityInfo _o_)
/*      */   {
/*   48 */     this(_o_, null, null);
/*      */   }
/*      */   
/*      */   DrawCarnivalActivityInfo(xbean.DrawCarnivalActivityInfo _o1_, XBean _xp_, String _vn_)
/*      */   {
/*   53 */     super(_xp_, _vn_);
/*   54 */     if ((_o1_ instanceof DrawCarnivalActivityInfo)) { assign((DrawCarnivalActivityInfo)_o1_);
/*   55 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*   56 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*   57 */       throw new UnsupportedOperationException();
/*      */     }
/*      */   }
/*      */   
/*      */   private void assign(DrawCarnivalActivityInfo _o_) {
/*   62 */     _o_._xdb_verify_unsafe_();
/*   63 */     this.last_winner_role_info = new DrawCarnivalAwardWinnerInfo(_o_.last_winner_role_info, this, "last_winner_role_info");
/*   64 */     this.accumulate_yuan_bao_cost_count = _o_.accumulate_yuan_bao_cost_count;
/*   65 */     this.pass_type_id2extra_rate_per_pass = new HashMap();
/*   66 */     for (Map.Entry<Integer, Integer> _e_ : _o_.pass_type_id2extra_rate_per_pass.entrySet())
/*   67 */       this.pass_type_id2extra_rate_per_pass.put(_e_.getKey(), _e_.getValue());
/*   68 */     this.big_award_count = _o_.big_award_count;
/*   69 */     this.random_type_id2chest_count = new HashMap();
/*   70 */     for (Map.Entry<Integer, Integer> _e_ : _o_.random_type_id2chest_count.entrySet()) {
/*   71 */       this.random_type_id2chest_count.put(_e_.getKey(), _e_.getValue());
/*      */     }
/*      */   }
/*      */   
/*      */   private void assign(Data _o_) {
/*   76 */     this.last_winner_role_info = new DrawCarnivalAwardWinnerInfo(_o_.last_winner_role_info, this, "last_winner_role_info");
/*   77 */     this.accumulate_yuan_bao_cost_count = _o_.accumulate_yuan_bao_cost_count;
/*   78 */     this.pass_type_id2extra_rate_per_pass = new HashMap();
/*   79 */     for (Map.Entry<Integer, Integer> _e_ : _o_.pass_type_id2extra_rate_per_pass.entrySet())
/*   80 */       this.pass_type_id2extra_rate_per_pass.put(_e_.getKey(), _e_.getValue());
/*   81 */     this.big_award_count = _o_.big_award_count;
/*   82 */     this.random_type_id2chest_count = new HashMap();
/*   83 */     for (Map.Entry<Integer, Integer> _e_ : _o_.random_type_id2chest_count.entrySet()) {
/*   84 */       this.random_type_id2chest_count.put(_e_.getKey(), _e_.getValue());
/*      */     }
/*      */   }
/*      */   
/*      */   public final OctetsStream marshal(OctetsStream _os_)
/*      */   {
/*   90 */     _xdb_verify_unsafe_();
/*   91 */     this.last_winner_role_info.marshal(_os_);
/*   92 */     _os_.marshal(this.accumulate_yuan_bao_cost_count);
/*   93 */     _os_.compact_uint32(this.pass_type_id2extra_rate_per_pass.size());
/*   94 */     for (Map.Entry<Integer, Integer> _e_ : this.pass_type_id2extra_rate_per_pass.entrySet())
/*      */     {
/*   96 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/*   97 */       _os_.marshal(((Integer)_e_.getValue()).intValue());
/*      */     }
/*   99 */     _os_.marshal(this.big_award_count);
/*  100 */     _os_.compact_uint32(this.random_type_id2chest_count.size());
/*  101 */     for (Map.Entry<Integer, Integer> _e_ : this.random_type_id2chest_count.entrySet())
/*      */     {
/*  103 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/*  104 */       _os_.marshal(((Integer)_e_.getValue()).intValue());
/*      */     }
/*  106 */     return _os_;
/*      */   }
/*      */   
/*      */   public final OctetsStream unmarshal(OctetsStream _os_)
/*      */     throws com.goldhuman.Common.Marshal.MarshalException
/*      */   {
/*  112 */     _xdb_verify_unsafe_();
/*  113 */     this.last_winner_role_info.unmarshal(_os_);
/*  114 */     this.accumulate_yuan_bao_cost_count = _os_.unmarshal_long();
/*      */     
/*  116 */     int size = _os_.uncompact_uint32();
/*  117 */     if (size >= 12)
/*      */     {
/*  119 */       this.pass_type_id2extra_rate_per_pass = new HashMap(size * 2);
/*      */     }
/*  121 */     for (; size > 0; size--)
/*      */     {
/*  123 */       int _k_ = 0;
/*  124 */       _k_ = _os_.unmarshal_int();
/*  125 */       int _v_ = 0;
/*  126 */       _v_ = _os_.unmarshal_int();
/*  127 */       this.pass_type_id2extra_rate_per_pass.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*      */     }
/*      */     
/*  130 */     this.big_award_count = _os_.unmarshal_int();
/*      */     
/*  132 */     int size = _os_.uncompact_uint32();
/*  133 */     if (size >= 12)
/*      */     {
/*  135 */       this.random_type_id2chest_count = new HashMap(size * 2);
/*      */     }
/*  137 */     for (; size > 0; size--)
/*      */     {
/*  139 */       int _k_ = 0;
/*  140 */       _k_ = _os_.unmarshal_int();
/*  141 */       int _v_ = 0;
/*  142 */       _v_ = _os_.unmarshal_int();
/*  143 */       this.random_type_id2chest_count.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*      */     }
/*      */     
/*  146 */     return _os_;
/*      */   }
/*      */   
/*      */ 
/*      */   public int getSerializedSize()
/*      */   {
/*  152 */     _xdb_verify_unsafe_();
/*  153 */     int _size_ = 0;
/*  154 */     _size_ += CodedOutputStream.computeMessageSize(1, this.last_winner_role_info);
/*  155 */     _size_ += CodedOutputStream.computeInt64Size(2, this.accumulate_yuan_bao_cost_count);
/*  156 */     for (Map.Entry<Integer, Integer> _e_ : this.pass_type_id2extra_rate_per_pass.entrySet())
/*      */     {
/*  158 */       _size_ += CodedOutputStream.computeInt32Size(3, ((Integer)_e_.getKey()).intValue());
/*  159 */       _size_ += CodedOutputStream.computeInt32Size(3, ((Integer)_e_.getValue()).intValue());
/*      */     }
/*  161 */     _size_ += CodedOutputStream.computeInt32Size(4, this.big_award_count);
/*  162 */     for (Map.Entry<Integer, Integer> _e_ : this.random_type_id2chest_count.entrySet())
/*      */     {
/*  164 */       _size_ += CodedOutputStream.computeInt32Size(5, ((Integer)_e_.getKey()).intValue());
/*  165 */       _size_ += CodedOutputStream.computeInt32Size(5, ((Integer)_e_.getValue()).intValue());
/*      */     }
/*  167 */     return _size_;
/*      */   }
/*      */   
/*      */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */     throws InvalidProtocolBufferException
/*      */   {
/*  173 */     _xdb_verify_unsafe_();
/*      */     try
/*      */     {
/*  176 */       _output_.writeMessage(1, this.last_winner_role_info);
/*  177 */       _output_.writeInt64(2, this.accumulate_yuan_bao_cost_count);
/*  178 */       for (Map.Entry<Integer, Integer> _e_ : this.pass_type_id2extra_rate_per_pass.entrySet())
/*      */       {
/*  180 */         _output_.writeInt32(3, ((Integer)_e_.getKey()).intValue());
/*  181 */         _output_.writeInt32(3, ((Integer)_e_.getValue()).intValue());
/*      */       }
/*  183 */       _output_.writeInt32(4, this.big_award_count);
/*  184 */       for (Map.Entry<Integer, Integer> _e_ : this.random_type_id2chest_count.entrySet())
/*      */       {
/*  186 */         _output_.writeInt32(5, ((Integer)_e_.getKey()).intValue());
/*  187 */         _output_.writeInt32(5, ((Integer)_e_.getValue()).intValue());
/*      */       }
/*      */     }
/*      */     catch (IOException e)
/*      */     {
/*  192 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */     }
/*  194 */     return _output_;
/*      */   }
/*      */   
/*      */   public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */     throws InvalidProtocolBufferException
/*      */   {
/*  200 */     _xdb_verify_unsafe_();
/*      */     try
/*      */     {
/*  203 */       boolean done = false;
/*  204 */       while (!done)
/*      */       {
/*  206 */         int tag = _input_.readTag();
/*  207 */         switch (tag)
/*      */         {
/*      */ 
/*      */         case 0: 
/*  211 */           done = true;
/*  212 */           break;
/*      */         
/*      */ 
/*      */         case 10: 
/*  216 */           _input_.readMessage(this.last_winner_role_info);
/*  217 */           break;
/*      */         
/*      */ 
/*      */         case 16: 
/*  221 */           this.accumulate_yuan_bao_cost_count = _input_.readInt64();
/*  222 */           break;
/*      */         
/*      */ 
/*      */         case 24: 
/*  226 */           int _k_ = 0;
/*  227 */           _k_ = _input_.readInt32();
/*  228 */           int readTag = _input_.readTag();
/*  229 */           if (24 != readTag)
/*      */           {
/*  231 */             throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*      */           }
/*  233 */           int _v_ = 0;
/*  234 */           _v_ = _input_.readInt32();
/*  235 */           this.pass_type_id2extra_rate_per_pass.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*  236 */           break;
/*      */         
/*      */ 
/*      */         case 32: 
/*  240 */           this.big_award_count = _input_.readInt32();
/*  241 */           break;
/*      */         
/*      */ 
/*      */         case 40: 
/*  245 */           int _k_ = 0;
/*  246 */           _k_ = _input_.readInt32();
/*  247 */           int readTag = _input_.readTag();
/*  248 */           if (40 != readTag)
/*      */           {
/*  250 */             throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*      */           }
/*  252 */           int _v_ = 0;
/*  253 */           _v_ = _input_.readInt32();
/*  254 */           this.random_type_id2chest_count.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
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
/*      */   public xbean.DrawCarnivalActivityInfo copy()
/*      */   {
/*  282 */     _xdb_verify_unsafe_();
/*  283 */     return new DrawCarnivalActivityInfo(this);
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.DrawCarnivalActivityInfo toData()
/*      */   {
/*  289 */     _xdb_verify_unsafe_();
/*  290 */     return new Data(this);
/*      */   }
/*      */   
/*      */   public xbean.DrawCarnivalActivityInfo toBean()
/*      */   {
/*  295 */     _xdb_verify_unsafe_();
/*  296 */     return new DrawCarnivalActivityInfo(this);
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.DrawCarnivalActivityInfo toDataIf()
/*      */   {
/*  302 */     _xdb_verify_unsafe_();
/*  303 */     return new Data(this);
/*      */   }
/*      */   
/*      */   public xbean.DrawCarnivalActivityInfo toBeanIf()
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
/*      */   public xbean.DrawCarnivalAwardWinnerInfo getLast_winner_role_info()
/*      */   {
/*  323 */     _xdb_verify_unsafe_();
/*  324 */     return this.last_winner_role_info;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public long getAccumulate_yuan_bao_cost_count()
/*      */   {
/*  331 */     _xdb_verify_unsafe_();
/*  332 */     return this.accumulate_yuan_bao_cost_count;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<Integer, Integer> getPass_type_id2extra_rate_per_pass()
/*      */   {
/*  339 */     _xdb_verify_unsafe_();
/*  340 */     return xdb.Logs.logMap(new LogKey(this, "pass_type_id2extra_rate_per_pass"), this.pass_type_id2extra_rate_per_pass);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<Integer, Integer> getPass_type_id2extra_rate_per_passAsData()
/*      */   {
/*  347 */     _xdb_verify_unsafe_();
/*      */     
/*  349 */     DrawCarnivalActivityInfo _o_ = this;
/*  350 */     Map<Integer, Integer> pass_type_id2extra_rate_per_pass = new HashMap();
/*  351 */     for (Map.Entry<Integer, Integer> _e_ : _o_.pass_type_id2extra_rate_per_pass.entrySet())
/*  352 */       pass_type_id2extra_rate_per_pass.put(_e_.getKey(), _e_.getValue());
/*  353 */     return pass_type_id2extra_rate_per_pass;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getBig_award_count()
/*      */   {
/*  360 */     _xdb_verify_unsafe_();
/*  361 */     return this.big_award_count;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<Integer, Integer> getRandom_type_id2chest_count()
/*      */   {
/*  368 */     _xdb_verify_unsafe_();
/*  369 */     return xdb.Logs.logMap(new LogKey(this, "random_type_id2chest_count"), this.random_type_id2chest_count);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<Integer, Integer> getRandom_type_id2chest_countAsData()
/*      */   {
/*  376 */     _xdb_verify_unsafe_();
/*      */     
/*  378 */     DrawCarnivalActivityInfo _o_ = this;
/*  379 */     Map<Integer, Integer> random_type_id2chest_count = new HashMap();
/*  380 */     for (Map.Entry<Integer, Integer> _e_ : _o_.random_type_id2chest_count.entrySet())
/*  381 */       random_type_id2chest_count.put(_e_.getKey(), _e_.getValue());
/*  382 */     return random_type_id2chest_count;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setAccumulate_yuan_bao_cost_count(long _v_)
/*      */   {
/*  389 */     _xdb_verify_unsafe_();
/*  390 */     xdb.Logs.logIf(new LogKey(this, "accumulate_yuan_bao_cost_count")
/*      */     {
/*      */       protected xdb.Log create()
/*      */       {
/*  394 */         new xdb.logs.LogLong(this, DrawCarnivalActivityInfo.this.accumulate_yuan_bao_cost_count)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  398 */             DrawCarnivalActivityInfo.this.accumulate_yuan_bao_cost_count = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  402 */     });
/*  403 */     this.accumulate_yuan_bao_cost_count = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setBig_award_count(int _v_)
/*      */   {
/*  410 */     _xdb_verify_unsafe_();
/*  411 */     xdb.Logs.logIf(new LogKey(this, "big_award_count")
/*      */     {
/*      */       protected xdb.Log create()
/*      */       {
/*  415 */         new xdb.logs.LogInt(this, DrawCarnivalActivityInfo.this.big_award_count)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  419 */             DrawCarnivalActivityInfo.this.big_award_count = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  423 */     });
/*  424 */     this.big_award_count = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */   public final boolean equals(Object _o1_)
/*      */   {
/*  430 */     _xdb_verify_unsafe_();
/*  431 */     DrawCarnivalActivityInfo _o_ = null;
/*  432 */     if ((_o1_ instanceof DrawCarnivalActivityInfo)) { _o_ = (DrawCarnivalActivityInfo)_o1_;
/*  433 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/*  434 */       return false;
/*  435 */     if (!this.last_winner_role_info.equals(_o_.last_winner_role_info)) return false;
/*  436 */     if (this.accumulate_yuan_bao_cost_count != _o_.accumulate_yuan_bao_cost_count) return false;
/*  437 */     if (!this.pass_type_id2extra_rate_per_pass.equals(_o_.pass_type_id2extra_rate_per_pass)) return false;
/*  438 */     if (this.big_award_count != _o_.big_award_count) return false;
/*  439 */     if (!this.random_type_id2chest_count.equals(_o_.random_type_id2chest_count)) return false;
/*  440 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */   public final int hashCode()
/*      */   {
/*  446 */     _xdb_verify_unsafe_();
/*  447 */     int _h_ = 0;
/*  448 */     _h_ += this.last_winner_role_info.hashCode();
/*  449 */     _h_ = (int)(_h_ + this.accumulate_yuan_bao_cost_count);
/*  450 */     _h_ += this.pass_type_id2extra_rate_per_pass.hashCode();
/*  451 */     _h_ += this.big_award_count;
/*  452 */     _h_ += this.random_type_id2chest_count.hashCode();
/*  453 */     return _h_;
/*      */   }
/*      */   
/*      */ 
/*      */   public String toString()
/*      */   {
/*  459 */     _xdb_verify_unsafe_();
/*  460 */     StringBuilder _sb_ = new StringBuilder();
/*  461 */     _sb_.append("(");
/*  462 */     _sb_.append(this.last_winner_role_info);
/*  463 */     _sb_.append(",");
/*  464 */     _sb_.append(this.accumulate_yuan_bao_cost_count);
/*  465 */     _sb_.append(",");
/*  466 */     _sb_.append(this.pass_type_id2extra_rate_per_pass);
/*  467 */     _sb_.append(",");
/*  468 */     _sb_.append(this.big_award_count);
/*  469 */     _sb_.append(",");
/*  470 */     _sb_.append(this.random_type_id2chest_count);
/*  471 */     _sb_.append(")");
/*  472 */     return _sb_.toString();
/*      */   }
/*      */   
/*      */ 
/*      */   public xdb.logs.Listenable newListenable()
/*      */   {
/*  478 */     ListenableBean lb = new ListenableBean();
/*  479 */     lb.add(new ListenableChanged().setVarName("last_winner_role_info"));
/*  480 */     lb.add(new ListenableChanged().setVarName("accumulate_yuan_bao_cost_count"));
/*  481 */     lb.add(new xdb.logs.ListenableMap().setVarName("pass_type_id2extra_rate_per_pass"));
/*  482 */     lb.add(new ListenableChanged().setVarName("big_award_count"));
/*  483 */     lb.add(new xdb.logs.ListenableMap().setVarName("random_type_id2chest_count"));
/*  484 */     return lb;
/*      */   }
/*      */   
/*      */   private class Const implements xbean.DrawCarnivalActivityInfo {
/*      */     private Const() {}
/*      */     
/*      */     DrawCarnivalActivityInfo nThis() {
/*  491 */       return DrawCarnivalActivityInfo.this;
/*      */     }
/*      */     
/*      */ 
/*      */     public void _reset_unsafe_()
/*      */     {
/*  497 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.DrawCarnivalActivityInfo copy()
/*      */     {
/*  503 */       return DrawCarnivalActivityInfo.this.copy();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.DrawCarnivalActivityInfo toData()
/*      */     {
/*  509 */       return DrawCarnivalActivityInfo.this.toData();
/*      */     }
/*      */     
/*      */     public xbean.DrawCarnivalActivityInfo toBean()
/*      */     {
/*  514 */       return DrawCarnivalActivityInfo.this.toBean();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.DrawCarnivalActivityInfo toDataIf()
/*      */     {
/*  520 */       return DrawCarnivalActivityInfo.this.toDataIf();
/*      */     }
/*      */     
/*      */     public xbean.DrawCarnivalActivityInfo toBeanIf()
/*      */     {
/*  525 */       return DrawCarnivalActivityInfo.this.toBeanIf();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public xbean.DrawCarnivalAwardWinnerInfo getLast_winner_role_info()
/*      */     {
/*  532 */       DrawCarnivalActivityInfo.this._xdb_verify_unsafe_();
/*  533 */       return (xbean.DrawCarnivalAwardWinnerInfo)xdb.Consts.toConst(DrawCarnivalActivityInfo.this.last_winner_role_info);
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getAccumulate_yuan_bao_cost_count()
/*      */     {
/*  540 */       DrawCarnivalActivityInfo.this._xdb_verify_unsafe_();
/*  541 */       return DrawCarnivalActivityInfo.this.accumulate_yuan_bao_cost_count;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, Integer> getPass_type_id2extra_rate_per_pass()
/*      */     {
/*  548 */       DrawCarnivalActivityInfo.this._xdb_verify_unsafe_();
/*  549 */       return xdb.Consts.constMap(DrawCarnivalActivityInfo.this.pass_type_id2extra_rate_per_pass);
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, Integer> getPass_type_id2extra_rate_per_passAsData()
/*      */     {
/*  556 */       DrawCarnivalActivityInfo.this._xdb_verify_unsafe_();
/*      */       
/*  558 */       DrawCarnivalActivityInfo _o_ = DrawCarnivalActivityInfo.this;
/*  559 */       Map<Integer, Integer> pass_type_id2extra_rate_per_pass = new HashMap();
/*  560 */       for (Map.Entry<Integer, Integer> _e_ : _o_.pass_type_id2extra_rate_per_pass.entrySet())
/*  561 */         pass_type_id2extra_rate_per_pass.put(_e_.getKey(), _e_.getValue());
/*  562 */       return pass_type_id2extra_rate_per_pass;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getBig_award_count()
/*      */     {
/*  569 */       DrawCarnivalActivityInfo.this._xdb_verify_unsafe_();
/*  570 */       return DrawCarnivalActivityInfo.this.big_award_count;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, Integer> getRandom_type_id2chest_count()
/*      */     {
/*  577 */       DrawCarnivalActivityInfo.this._xdb_verify_unsafe_();
/*  578 */       return xdb.Consts.constMap(DrawCarnivalActivityInfo.this.random_type_id2chest_count);
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, Integer> getRandom_type_id2chest_countAsData()
/*      */     {
/*  585 */       DrawCarnivalActivityInfo.this._xdb_verify_unsafe_();
/*      */       
/*  587 */       DrawCarnivalActivityInfo _o_ = DrawCarnivalActivityInfo.this;
/*  588 */       Map<Integer, Integer> random_type_id2chest_count = new HashMap();
/*  589 */       for (Map.Entry<Integer, Integer> _e_ : _o_.random_type_id2chest_count.entrySet())
/*  590 */         random_type_id2chest_count.put(_e_.getKey(), _e_.getValue());
/*  591 */       return random_type_id2chest_count;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setAccumulate_yuan_bao_cost_count(long _v_)
/*      */     {
/*  598 */       DrawCarnivalActivityInfo.this._xdb_verify_unsafe_();
/*  599 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setBig_award_count(int _v_)
/*      */     {
/*  606 */       DrawCarnivalActivityInfo.this._xdb_verify_unsafe_();
/*  607 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xdb.Bean toConst()
/*      */     {
/*  613 */       DrawCarnivalActivityInfo.this._xdb_verify_unsafe_();
/*  614 */       return this;
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean isConst()
/*      */     {
/*  620 */       DrawCarnivalActivityInfo.this._xdb_verify_unsafe_();
/*  621 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean isData()
/*      */     {
/*  627 */       return DrawCarnivalActivityInfo.this.isData();
/*      */     }
/*      */     
/*      */ 
/*      */     public OctetsStream marshal(OctetsStream _os_)
/*      */     {
/*  633 */       return DrawCarnivalActivityInfo.this.marshal(_os_);
/*      */     }
/*      */     
/*      */     public OctetsStream unmarshal(OctetsStream _os_)
/*      */       throws com.goldhuman.Common.Marshal.MarshalException
/*      */     {
/*  639 */       DrawCarnivalActivityInfo.this._xdb_verify_unsafe_();
/*  640 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public int getSerializedSize()
/*      */     {
/*  646 */       return DrawCarnivalActivityInfo.this.getSerializedSize();
/*      */     }
/*      */     
/*      */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*  652 */       return DrawCarnivalActivityInfo.this.marshal(_output_);
/*      */     }
/*      */     
/*      */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*  658 */       DrawCarnivalActivityInfo.this._xdb_verify_unsafe_();
/*  659 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xdb.Bean xdbParent()
/*      */     {
/*  665 */       return DrawCarnivalActivityInfo.this.xdbParent();
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean xdbManaged()
/*      */     {
/*  671 */       return DrawCarnivalActivityInfo.this.xdbManaged();
/*      */     }
/*      */     
/*      */ 
/*      */     public String xdbVarname()
/*      */     {
/*  677 */       return DrawCarnivalActivityInfo.this.xdbVarname();
/*      */     }
/*      */     
/*      */ 
/*      */     public Long xdbObjId()
/*      */     {
/*  683 */       return DrawCarnivalActivityInfo.this.xdbObjId();
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean equals(Object obj)
/*      */     {
/*  689 */       return DrawCarnivalActivityInfo.this.equals(obj);
/*      */     }
/*      */     
/*      */ 
/*      */     public int hashCode()
/*      */     {
/*  695 */       return DrawCarnivalActivityInfo.this.hashCode();
/*      */     }
/*      */     
/*      */ 
/*      */     public String toString()
/*      */     {
/*  701 */       return DrawCarnivalActivityInfo.this.toString();
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */   public static final class Data
/*      */     implements xbean.DrawCarnivalActivityInfo
/*      */   {
/*      */     private xbean.DrawCarnivalAwardWinnerInfo last_winner_role_info;
/*      */     
/*      */     private long accumulate_yuan_bao_cost_count;
/*      */     
/*      */     private HashMap<Integer, Integer> pass_type_id2extra_rate_per_pass;
/*      */     
/*      */     private int big_award_count;
/*      */     
/*      */     private HashMap<Integer, Integer> random_type_id2chest_count;
/*      */     
/*      */     public void _reset_unsafe_()
/*      */     {
/*  721 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Data()
/*      */     {
/*  726 */       this.last_winner_role_info = new DrawCarnivalAwardWinnerInfo.Data();
/*  727 */       this.pass_type_id2extra_rate_per_pass = new HashMap();
/*  728 */       this.random_type_id2chest_count = new HashMap();
/*      */     }
/*      */     
/*      */     Data(xbean.DrawCarnivalActivityInfo _o1_)
/*      */     {
/*  733 */       if ((_o1_ instanceof DrawCarnivalActivityInfo)) { assign((DrawCarnivalActivityInfo)_o1_);
/*  734 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  735 */       } else if ((_o1_ instanceof DrawCarnivalActivityInfo.Const)) assign(((DrawCarnivalActivityInfo.Const)_o1_).nThis()); else {
/*  736 */         throw new UnsupportedOperationException();
/*      */       }
/*      */     }
/*      */     
/*      */     private void assign(DrawCarnivalActivityInfo _o_) {
/*  741 */       this.last_winner_role_info = new DrawCarnivalAwardWinnerInfo.Data(_o_.last_winner_role_info);
/*  742 */       this.accumulate_yuan_bao_cost_count = _o_.accumulate_yuan_bao_cost_count;
/*  743 */       this.pass_type_id2extra_rate_per_pass = new HashMap();
/*  744 */       for (Map.Entry<Integer, Integer> _e_ : _o_.pass_type_id2extra_rate_per_pass.entrySet())
/*  745 */         this.pass_type_id2extra_rate_per_pass.put(_e_.getKey(), _e_.getValue());
/*  746 */       this.big_award_count = _o_.big_award_count;
/*  747 */       this.random_type_id2chest_count = new HashMap();
/*  748 */       for (Map.Entry<Integer, Integer> _e_ : _o_.random_type_id2chest_count.entrySet()) {
/*  749 */         this.random_type_id2chest_count.put(_e_.getKey(), _e_.getValue());
/*      */       }
/*      */     }
/*      */     
/*      */     private void assign(Data _o_) {
/*  754 */       this.last_winner_role_info = new DrawCarnivalAwardWinnerInfo.Data(_o_.last_winner_role_info);
/*  755 */       this.accumulate_yuan_bao_cost_count = _o_.accumulate_yuan_bao_cost_count;
/*  756 */       this.pass_type_id2extra_rate_per_pass = new HashMap();
/*  757 */       for (Map.Entry<Integer, Integer> _e_ : _o_.pass_type_id2extra_rate_per_pass.entrySet())
/*  758 */         this.pass_type_id2extra_rate_per_pass.put(_e_.getKey(), _e_.getValue());
/*  759 */       this.big_award_count = _o_.big_award_count;
/*  760 */       this.random_type_id2chest_count = new HashMap();
/*  761 */       for (Map.Entry<Integer, Integer> _e_ : _o_.random_type_id2chest_count.entrySet()) {
/*  762 */         this.random_type_id2chest_count.put(_e_.getKey(), _e_.getValue());
/*      */       }
/*      */     }
/*      */     
/*      */     public final OctetsStream marshal(OctetsStream _os_)
/*      */     {
/*  768 */       this.last_winner_role_info.marshal(_os_);
/*  769 */       _os_.marshal(this.accumulate_yuan_bao_cost_count);
/*  770 */       _os_.compact_uint32(this.pass_type_id2extra_rate_per_pass.size());
/*  771 */       for (Map.Entry<Integer, Integer> _e_ : this.pass_type_id2extra_rate_per_pass.entrySet())
/*      */       {
/*  773 */         _os_.marshal(((Integer)_e_.getKey()).intValue());
/*  774 */         _os_.marshal(((Integer)_e_.getValue()).intValue());
/*      */       }
/*  776 */       _os_.marshal(this.big_award_count);
/*  777 */       _os_.compact_uint32(this.random_type_id2chest_count.size());
/*  778 */       for (Map.Entry<Integer, Integer> _e_ : this.random_type_id2chest_count.entrySet())
/*      */       {
/*  780 */         _os_.marshal(((Integer)_e_.getKey()).intValue());
/*  781 */         _os_.marshal(((Integer)_e_.getValue()).intValue());
/*      */       }
/*  783 */       return _os_;
/*      */     }
/*      */     
/*      */     public final OctetsStream unmarshal(OctetsStream _os_)
/*      */       throws com.goldhuman.Common.Marshal.MarshalException
/*      */     {
/*  789 */       this.last_winner_role_info.unmarshal(_os_);
/*  790 */       this.accumulate_yuan_bao_cost_count = _os_.unmarshal_long();
/*      */       
/*  792 */       int size = _os_.uncompact_uint32();
/*  793 */       if (size >= 12)
/*      */       {
/*  795 */         this.pass_type_id2extra_rate_per_pass = new HashMap(size * 2);
/*      */       }
/*  797 */       for (; size > 0; size--)
/*      */       {
/*  799 */         int _k_ = 0;
/*  800 */         _k_ = _os_.unmarshal_int();
/*  801 */         int _v_ = 0;
/*  802 */         _v_ = _os_.unmarshal_int();
/*  803 */         this.pass_type_id2extra_rate_per_pass.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*      */       }
/*      */       
/*  806 */       this.big_award_count = _os_.unmarshal_int();
/*      */       
/*  808 */       int size = _os_.uncompact_uint32();
/*  809 */       if (size >= 12)
/*      */       {
/*  811 */         this.random_type_id2chest_count = new HashMap(size * 2);
/*      */       }
/*  813 */       for (; size > 0; size--)
/*      */       {
/*  815 */         int _k_ = 0;
/*  816 */         _k_ = _os_.unmarshal_int();
/*  817 */         int _v_ = 0;
/*  818 */         _v_ = _os_.unmarshal_int();
/*  819 */         this.random_type_id2chest_count.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*      */       }
/*      */       
/*  822 */       return _os_;
/*      */     }
/*      */     
/*      */ 
/*      */     public final int getSerializedSize()
/*      */     {
/*  828 */       int _size_ = 0;
/*  829 */       _size_ += CodedOutputStream.computeMessageSize(1, this.last_winner_role_info);
/*  830 */       _size_ += CodedOutputStream.computeInt64Size(2, this.accumulate_yuan_bao_cost_count);
/*  831 */       for (Map.Entry<Integer, Integer> _e_ : this.pass_type_id2extra_rate_per_pass.entrySet())
/*      */       {
/*  833 */         _size_ += CodedOutputStream.computeInt32Size(3, ((Integer)_e_.getKey()).intValue());
/*  834 */         _size_ += CodedOutputStream.computeInt32Size(3, ((Integer)_e_.getValue()).intValue());
/*      */       }
/*  836 */       _size_ += CodedOutputStream.computeInt32Size(4, this.big_award_count);
/*  837 */       for (Map.Entry<Integer, Integer> _e_ : this.random_type_id2chest_count.entrySet())
/*      */       {
/*  839 */         _size_ += CodedOutputStream.computeInt32Size(5, ((Integer)_e_.getKey()).intValue());
/*  840 */         _size_ += CodedOutputStream.computeInt32Size(5, ((Integer)_e_.getValue()).intValue());
/*      */       }
/*  842 */       return _size_;
/*      */     }
/*      */     
/*      */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*      */       try
/*      */       {
/*  850 */         _output_.writeMessage(1, this.last_winner_role_info);
/*  851 */         _output_.writeInt64(2, this.accumulate_yuan_bao_cost_count);
/*  852 */         for (Map.Entry<Integer, Integer> _e_ : this.pass_type_id2extra_rate_per_pass.entrySet())
/*      */         {
/*  854 */           _output_.writeInt32(3, ((Integer)_e_.getKey()).intValue());
/*  855 */           _output_.writeInt32(3, ((Integer)_e_.getValue()).intValue());
/*      */         }
/*  857 */         _output_.writeInt32(4, this.big_award_count);
/*  858 */         for (Map.Entry<Integer, Integer> _e_ : this.random_type_id2chest_count.entrySet())
/*      */         {
/*  860 */           _output_.writeInt32(5, ((Integer)_e_.getKey()).intValue());
/*  861 */           _output_.writeInt32(5, ((Integer)_e_.getValue()).intValue());
/*      */         }
/*      */       }
/*      */       catch (IOException e)
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
/*      */           case 10: 
/*  889 */             _input_.readMessage(this.last_winner_role_info);
/*  890 */             break;
/*      */           
/*      */ 
/*      */           case 16: 
/*  894 */             this.accumulate_yuan_bao_cost_count = _input_.readInt64();
/*  895 */             break;
/*      */           
/*      */ 
/*      */           case 24: 
/*  899 */             int _k_ = 0;
/*  900 */             _k_ = _input_.readInt32();
/*  901 */             int readTag = _input_.readTag();
/*  902 */             if (24 != readTag)
/*      */             {
/*  904 */               throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*      */             }
/*  906 */             int _v_ = 0;
/*  907 */             _v_ = _input_.readInt32();
/*  908 */             this.pass_type_id2extra_rate_per_pass.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*  909 */             break;
/*      */           
/*      */ 
/*      */           case 32: 
/*  913 */             this.big_award_count = _input_.readInt32();
/*  914 */             break;
/*      */           
/*      */ 
/*      */           case 40: 
/*  918 */             int _k_ = 0;
/*  919 */             _k_ = _input_.readInt32();
/*  920 */             int readTag = _input_.readTag();
/*  921 */             if (40 != readTag)
/*      */             {
/*  923 */               throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*      */             }
/*  925 */             int _v_ = 0;
/*  926 */             _v_ = _input_.readInt32();
/*  927 */             this.random_type_id2chest_count.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*  928 */             break;
/*      */           
/*      */ 
/*      */           default: 
/*  932 */             if (!CodedInputStream.skipUnknownField(tag, _input_))
/*      */             {
/*  934 */               done = true;
/*      */             }
/*      */             break;
/*      */           }
/*      */           
/*      */         }
/*      */       }
/*      */       catch (InvalidProtocolBufferException e)
/*      */       {
/*  943 */         throw e.setUnfinishedMessage(this);
/*      */       }
/*      */       catch (IOException e)
/*      */       {
/*  947 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */       }
/*  949 */       return _input_;
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.DrawCarnivalActivityInfo copy()
/*      */     {
/*  955 */       return new Data(this);
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.DrawCarnivalActivityInfo toData()
/*      */     {
/*  961 */       return new Data(this);
/*      */     }
/*      */     
/*      */     public xbean.DrawCarnivalActivityInfo toBean()
/*      */     {
/*  966 */       return new DrawCarnivalActivityInfo(this, null, null);
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.DrawCarnivalActivityInfo toDataIf()
/*      */     {
/*  972 */       return this;
/*      */     }
/*      */     
/*      */     public xbean.DrawCarnivalActivityInfo toBeanIf()
/*      */     {
/*  977 */       return new DrawCarnivalActivityInfo(this, null, null);
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean xdbManaged()
/*      */     {
/*  983 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public xdb.Bean xdbParent() {
/*  987 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public String xdbVarname() {
/*  991 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Long xdbObjId() {
/*  995 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public xdb.Bean toConst() {
/*  999 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public boolean isConst() {
/* 1003 */       return false;
/*      */     }
/*      */     
/*      */     public boolean isData() {
/* 1007 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public xbean.DrawCarnivalAwardWinnerInfo getLast_winner_role_info()
/*      */     {
/* 1014 */       return this.last_winner_role_info;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getAccumulate_yuan_bao_cost_count()
/*      */     {
/* 1021 */       return this.accumulate_yuan_bao_cost_count;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, Integer> getPass_type_id2extra_rate_per_pass()
/*      */     {
/* 1028 */       return this.pass_type_id2extra_rate_per_pass;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, Integer> getPass_type_id2extra_rate_per_passAsData()
/*      */     {
/* 1035 */       return this.pass_type_id2extra_rate_per_pass;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getBig_award_count()
/*      */     {
/* 1042 */       return this.big_award_count;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, Integer> getRandom_type_id2chest_count()
/*      */     {
/* 1049 */       return this.random_type_id2chest_count;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, Integer> getRandom_type_id2chest_countAsData()
/*      */     {
/* 1056 */       return this.random_type_id2chest_count;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setAccumulate_yuan_bao_cost_count(long _v_)
/*      */     {
/* 1063 */       this.accumulate_yuan_bao_cost_count = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setBig_award_count(int _v_)
/*      */     {
/* 1070 */       this.big_award_count = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */     public final boolean equals(Object _o1_)
/*      */     {
/* 1076 */       if (!(_o1_ instanceof Data)) return false;
/* 1077 */       Data _o_ = (Data)_o1_;
/* 1078 */       if (!this.last_winner_role_info.equals(_o_.last_winner_role_info)) return false;
/* 1079 */       if (this.accumulate_yuan_bao_cost_count != _o_.accumulate_yuan_bao_cost_count) return false;
/* 1080 */       if (!this.pass_type_id2extra_rate_per_pass.equals(_o_.pass_type_id2extra_rate_per_pass)) return false;
/* 1081 */       if (this.big_award_count != _o_.big_award_count) return false;
/* 1082 */       if (!this.random_type_id2chest_count.equals(_o_.random_type_id2chest_count)) return false;
/* 1083 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */     public final int hashCode()
/*      */     {
/* 1089 */       int _h_ = 0;
/* 1090 */       _h_ += this.last_winner_role_info.hashCode();
/* 1091 */       _h_ = (int)(_h_ + this.accumulate_yuan_bao_cost_count);
/* 1092 */       _h_ += this.pass_type_id2extra_rate_per_pass.hashCode();
/* 1093 */       _h_ += this.big_award_count;
/* 1094 */       _h_ += this.random_type_id2chest_count.hashCode();
/* 1095 */       return _h_;
/*      */     }
/*      */     
/*      */ 
/*      */     public String toString()
/*      */     {
/* 1101 */       StringBuilder _sb_ = new StringBuilder();
/* 1102 */       _sb_.append("(");
/* 1103 */       _sb_.append(this.last_winner_role_info);
/* 1104 */       _sb_.append(",");
/* 1105 */       _sb_.append(this.accumulate_yuan_bao_cost_count);
/* 1106 */       _sb_.append(",");
/* 1107 */       _sb_.append(this.pass_type_id2extra_rate_per_pass);
/* 1108 */       _sb_.append(",");
/* 1109 */       _sb_.append(this.big_award_count);
/* 1110 */       _sb_.append(",");
/* 1111 */       _sb_.append(this.random_type_id2chest_count);
/* 1112 */       _sb_.append(")");
/* 1113 */       return _sb_.toString();
/*      */     }
/*      */   }
/*      */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\DrawCarnivalActivityInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */